package models



/**
 * Interface common to all kinds of users.
 */
trait User {
	def displayName: String
	
	def isAuthenticated: Boolean
	
	def isGuest: Boolean
}

