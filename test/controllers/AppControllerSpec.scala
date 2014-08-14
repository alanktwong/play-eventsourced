package controllers

import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AppControllerSpec extends Specification {

	"Application controller" should {
		"be testable" in {
			1 mustEqual 2
		}
		"use some fixture" in {
			1 mustEqual 1
		  
		}
	}
	
}