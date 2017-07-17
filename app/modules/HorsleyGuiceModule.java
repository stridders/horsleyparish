package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.jayway.jsonpath.spi.mapper.MappingProvider;
import controllers.UuidGenerator;
import play.Configuration;
import play.Environment;
import play.Logger;
import play.libs.akka.AkkaGuiceSupport;
import security.RoleBasedAuthoriser;
import security.UserAuthenticator;
import services.*;

import javax.net.ssl.SSLContext;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Created by js on 23/06/2016.
 */
public class HorsleyGuiceModule extends AbstractModule implements AkkaGuiceSupport  {

    Environment environment;
    Configuration configuration;
    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    public HorsleyGuiceModule(Environment env, Configuration conf) {
        this.environment = env;
        this.configuration = conf;
    }

    @Override
    protected void configure() {

        // Bind service classes to their implementations
        bind(UserService.class).to(UserServiceImpl.class);
        bind(DocumentService.class).to(DocumentServiceImpl.class);
        bind(DocumentTypeService.class).to(DocumentTypeServiceImpl.class);
        bind(DocumentGroupService.class).to(DocumentGroupServiceImpl.class);
        bind(GoogleDriveService.class).to(GoogleDriveServiceImpl.class);

        // Example of binding a collection of 'config' parameter  key/value (String, Integer) pairs to Java util annotations
//        this.configuration.
//                entrySet().
//                stream().
//                filter(e -> e.getKey().startsWith("config")).
//                forEach(configEntry -> {
//                    logger.debug(String.format("%s=$d", configEntry.getKey(), Integer.parseInt(configEntry.getValue().render())));
//                    bindConstant().annotatedWith(Names.named(configEntry.getKey())).to(Integer.parseInt(configEntry.getValue().render()));
//                });

//        // Example of binding a list of "config" key/value (String,String) pairs to a Map object
//        // Uses a custom provider method, to create a complex structure (i.e. a collection rather than a single key/value)
//        bind(new TypeLiteral<Map<String, String>>() {}).
//                annotatedWith(Names.named("param1")).toProvider(new ConfigMapProvider("config"));
//        bind(String.class).annotatedWith(Names.named("config")).toInstance(this.configuration.getString("config"));


//        String version = this.configuration.getString("app.version", "version not found");
//        bind(String.class).annotatedWith(Names.named("app.version")).toInstance(version);

//        // Example of binding SSL config to a custom SSL context object (e.g. for connectivity to an external web service)
//        SSLContext extSSLContext = new CustomSSLContext(configuration.getWrappedConfiguration()).createSSLContext("extSSL");
//        bind(SSLContext.class).annotatedWith(Names.named("extSSL")).toInstance(extSSLContext);

        // Static Injections for services and transformers
        requestStaticInjection(UuidGenerator.class);
        requestStaticInjection(UserServiceImpl.class);

    }


    public static class ConfigMapProvider<K, V> implements com.google.inject.Provider<Map<K, V>> {

        @Inject
        private Configuration configuration;

        private String key;

        public ConfigMapProvider(String key) {
            this.key = key;
        }

        @Override
        public Map<K, V> get() {
            Map<K, V> collect = configuration.getConfig(key).asMap()
                    .entrySet()
                    .stream()
                    .collect(Collectors.toMap(k -> (K) k.getKey(), v -> (V) v.getValue()));
            return collect;
        }
    }

    @Provides
    public com.jayway.jsonpath.Configuration.Defaults provideJsonPathConfigDefaults() {
        com.jayway.jsonpath.Configuration.Defaults defaults = new com.jayway.jsonpath.Configuration.Defaults() {

            private final JsonProvider jsonProvider = new JacksonJsonNodeJsonProvider();
            private final MappingProvider mappingProvider = new JacksonMappingProvider();

            @Override
            public JsonProvider jsonProvider() {
                return null;
            }

            @Override
            public Set<Option> options() {
                return null;
            }

            @Override
            public MappingProvider mappingProvider() {
                return null;
            }
        };
        return defaults;
    }
}
