/**
 * GotIt.Gadget module
 * 
 * @author Dany Jupille
 * @version 1.0
 */
window.GotIt.Gadget = (function () {
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  CONSTRUCTOR                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var Gadget = function() {
	
		this.nothing = null;
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  STATIC CODE                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	function getNothingPrivate() {
		return null;
	}
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            PROTOTYPE ADDITION(S)                             |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	Gadget.prototype.getNothingPublic = function() {
		return null;
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            RETURN MODULE STATEMENT                           |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	return Gadget;
})();
