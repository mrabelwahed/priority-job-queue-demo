package ramadan.com.priorityjobqueuedemo

import android.app.Application
import io.realm.Realm
import org.greenrobot.eventbus.EventBus

/**
 * Created by mahmoud on 04/07/18.
 */
class MyApp : Application() {

    public lateinit var eventBus: EventBus

    override fun onCreate() {
        super.onCreate()
        AppJobManager.getJobManager(this)
        Realm.init(this)

    }
}