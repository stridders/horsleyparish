
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/jstride/Documents/workspace/repository/horsleyparish/conf/routes
// @DATE:Tue Jul 04 20:24:50 BST 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseWebJarAssets WebJarAssets = new controllers.ReverseWebJarAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseGoogle Google = new controllers.ReverseGoogle(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUuidGenerator UuidGenerator = new controllers.ReverseUuidGenerator(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUser User = new controllers.ReverseUser(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseDocument Document = new controllers.ReverseDocument(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseWebJarAssets WebJarAssets = new controllers.javascript.ReverseWebJarAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseGoogle Google = new controllers.javascript.ReverseGoogle(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUuidGenerator UuidGenerator = new controllers.javascript.ReverseUuidGenerator(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUser User = new controllers.javascript.ReverseUser(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseDocument Document = new controllers.javascript.ReverseDocument(RoutesPrefix.byNamePrefix());
  }

}
