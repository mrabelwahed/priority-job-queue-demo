package ramadan.com.priorityjobqueuedemo

import com.birbit.android.jobqueue.JobManager
import com.birbit.android.jobqueue.scheduling.FrameworkJobSchedulerService



/**
 * Created by mahmoud on 04/07/18.
 */
class AppJobService : FrameworkJobSchedulerService() {

    override fun getJobManager(): JobManager {
        return AppJobManager.getJobManager()
    }
}