package ramadan.com.priorityjobqueuedemo

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * Created by mahmoud on 04/07/18.
 */
@RealmClass
open class Note :RealmModel {
    @PrimaryKey
    var id :String =""
    var content:String =""
}