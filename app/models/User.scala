package models


trait CurrentUserContext {
	/**
	 * The current authenticated user or the guest user.
	 */
	def currentUser: User
}


/**
 * Interface common to all kinds of users.
 */
trait User {
	def displayName: String
	
	def isAuthenticated: Boolean
	
	def isGuest: Boolean
}

