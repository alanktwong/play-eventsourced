package controllers

import play.api._
import play.api.mvc._


class Application extends BaseController {
	def index = Action { implicit request =>
		Ok(views.html.index("Hi!","Your new application is ready."))
	}
}