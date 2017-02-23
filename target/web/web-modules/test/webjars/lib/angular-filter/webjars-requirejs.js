requirejs.config({
    paths: { "angular-filter": webjars.path("angular-filter", "angular-filter") },
    shim: { "angular-filter": [ "angular" ] }
});
