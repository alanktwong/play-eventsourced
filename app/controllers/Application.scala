package controllers

import play.api._
import play.api.mvc._


class Application extends BaseController {
	def index = ViewContextAction { implicit contet =>
		Ok(views.html.index("Hi!","Your new application is ready."))
	}
}