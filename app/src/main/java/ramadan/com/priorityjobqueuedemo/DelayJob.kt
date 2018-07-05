package ramadan.com.priorityjobqueuedemo

import com.birbit.android.jobqueue.Job
import com.birbit.android.jobqueue.Params
import com.birbit.android.jobqueue.RetryConstraint
import io.realm.Realm
import org.greenrobot.eventbus.EventBus

/**
 * Created by mahmoud on 04/07/18.
 */
class DelayJob(var note:Note,params: Params?) : Job(params) {
    override fun onRun() {
        Thread.sleep(5000)
        Realm.getDefaultInstance().executeTransaction {
            realm->
            note.content = "I have one daughter"
            realm.insertOrUpdate(note)

        }
       EventBus.getDefault().post(EventMessage(note.id))
    }

    override fun shouldReRunOnThrowable(throwable: Throwable, runCount: Int, maxRunCount: Int): RetryConstraint? {
    return null
    }

    override fun onAdded() {
    }

    override fun onCancel(cancelReason: Int, throwable: Throwable?) {
    }
}