import play.api.mvc._

package object controllers {
	
	/**
	 * Context for use as an implicit parameter to views.
	 */
	trait ViewContext extends models.CurrentUserContext{
		def flash: Flash
		def lang: play.api.i18n.Lang
	}
	
	trait BaseController extends Controller with misc.Logging {
	
	}
}