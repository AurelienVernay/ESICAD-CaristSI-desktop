package controller

import ktorm.Caristes
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.ktorm.database.Database
import org.ktorm.dsl.*
import routing.Router
import routing.Routes

class LoginController: KoinComponent {
    private val database:Database by inject()
    private val router:Router by inject()
    fun loginUser(email:String, password:String) {

            println("Tentative de connexion avec $email et un mot de passe ${password}")
            if ((database.from(Caristes).select().where {
                    (Caristes.login eq email) and (Caristes.mdp eq password)
                }).iterator().hasNext()) {
                router.navigateTo(route = Routes.HOME)
            }
    }
}