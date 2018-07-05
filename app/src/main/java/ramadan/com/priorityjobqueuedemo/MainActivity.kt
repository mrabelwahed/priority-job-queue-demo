package ramadan.com.priorityjobqueuedemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.birbit.android.jobqueue.Params
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.*


class MainActivity : AppCompatActivity() {
   lateinit var eventBus:EventBus
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        eventBus = EventBus.getDefault()
        eventBus.register(this)
        save.setOnClickListener{
            val note = Note()
            note.id = UUID.randomUUID().toString()
            note.content = "HI I am Mahmoud Ramadan"

            Realm.getDefaultInstance().executeTransaction {
                realm ->  realm.insertOrUpdate(note)
            }

           val pa =  Params(1)
                    .requireUnmeteredNetwork()
                    .requireNetwork()
           AppJobManager.getJobManager().addJobInBackground(DelayJob(note,pa))
            AppJobManager.getJobManager().addJobInBackground(DelayJob(note,pa))
            AppJobManager.getJobManager().addJobInBackground(DelayJob(note,pa))
            AppJobManager.getJobManager().addJobInBackground(DelayJob(note,pa))
            AppJobManager.getJobManager().addJobInBackground(DelayJob(note,pa))
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(message: EventMessage) {
       Toast.makeText(applicationContext,message.str,Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        eventBus.unregister(this)
    }
}
