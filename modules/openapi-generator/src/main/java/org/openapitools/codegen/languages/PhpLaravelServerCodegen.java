/*
 * Copyright 2018 OpenAPI-Generator Contributors (https://openapi-generator.tech)
 * Copyright 2018 SmartBear Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openapitools.codegen.languages;

import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.CodegenProperty;
import org.openapitools.codegen.CodegenType;
import org.openapitools.codegen.SupportingFile;
import org.openapitools.codegen.meta.features.*;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.OperationMap;
import org.openapitools.codegen.model.OperationsMap;
import org.openapitools.codegen.utils.ModelUtils;

import io.swagger.v3.oas.models.media.Schema;

import java.io.File;
import java.util.*;

import static org.openapitools.codegen.utils.StringUtils.camelize;

public class PhpLaravelServerCodegen extends AbstractPhpCodegen {
    protected String apiVersion = "1.0.0";

    /**
     * Configures the type of generator.
     *
     * @return the CodegenType for this generator
     * @see org.openapitools.codegen.CodegenType
     */
    @Override
    public CodegenType getTag() {
        return CodegenType.SERVER;
    }

    /**
     * Configures a friendly name for the generator.  This will be used by the generator
     * to select the library with the -g flag.
     *
     * @return the friendly name for the generator
     */
    @Override
    public String getName() {
        return "php-laravel";
    }

    /**
     * Returns human-friendly help for the generator.  Provide the consumer with help
     * tips, parameters here
     *
     * @return A string value for the help message
     */
    @Override
    public String getHelp() {
        return "Generates a PHP laravel server library.";
    }

    /**
     * Class constructor
     */
    public PhpLaravelServerCodegen() {
        super();

        modifyFeatureSet(features -> features
                .includeDocumentationFeatures(DocumentationFeature.Readme)
                .wireFormatFeatures(EnumSet.of(WireFormatFeature.JSON, WireFormatFeature.XML))
                .securityFeatures(EnumSet.noneOf(SecurityFeature.class))
                .excludeGlobalFeatures(
                        GlobalFeature.XMLStructureDefinitions,
                        GlobalFeature.Callbacks,
                        GlobalFeature.LinkObjects,
                        GlobalFeature.ParameterStyling
                )
                .excludeSchemaSupportFeatures(
                        SchemaSupportFeature.Polymorphism
                )
        );

        embeddedTemplateDir = templateDir = "php-laravel";
        variableNamingConvention = "camelCase";

        /*
         * packPath
         */
        invokerPackage = "php-laravel";
        outputFolder = srcBasePath;

        /*
         * Api Package.  Optional, if needed, this can be used in templates
         */
        apiPackage = "app.Http.Controllers";

        /*
         * Model Package.  Optional, if needed, this can be used in templates
         */
        modelPackage = "app\\Models";

        // template files want to be ignored
        apiTestTemplateFiles.clear();
        apiDocTemplateFiles.clear();
        modelDocTemplateFiles.clear();

        /*
         * Additional Properties.  These values can be passed to the templates and
         * are available in models, apis, and supporting files
         */
        additionalProperties.put("apiVersion", apiVersion);

        /*
         * Supporting Files.  You can write single files for the generator with the
         * entire object tree available.  If the input file has a suffix of `.mustache
         * it will be processed by the template engine.  Otherwise, it will be copied
         */
        supportingFiles.add(new SupportingFile("composer.mustache", outputFolder, "composer.json"));
        supportingFiles.add(new SupportingFile("README.md", outputFolder, "README.md"));
        supportingFiles.add(new SupportingFile("artisan", outputFolder, "artisan"));
        supportingFiles.add(new SupportingFile("package.json", outputFolder, "package.json"));
        supportingFiles.add(new SupportingFile("phpunit.xml", outputFolder, "phpunit.xml"));
        supportingFiles.add(new SupportingFile("webpack.mix.js", outputFolder, "webpack.mix.js"));
        supportingFiles.add(new SupportingFile("editorconfig", outputFolder, ".editorconfig"));
        supportingFiles.add(new SupportingFile("env.example", outputFolder, ".env.example"));
        supportingFiles.add(new SupportingFile("gitattributes", outputFolder, ".gitattributes"));
        supportingFiles.add(new SupportingFile("styleci.yml", outputFolder, ".styleci.yml"));
        supportingFiles.add(new SupportingFile("server.php", outputFolder, "server.php"));
        supportingFiles.add(new SupportingFile("gitignore", outputFolder, ".gitignore"));

        supportingFiles.add(new SupportingFile("bootstrap/cache/gitignore", outputFolder + File.separator + "bootstrap" + File.separator + "cache", ".gitignore"));
        supportingFiles.add(new SupportingFile("bootstrap/app.php", outputFolder + File.separator + "bootstrap", "app.php"));

        /* /public/ */
        supportingFiles.add(new SupportingFile("public/.htaccess", outputFolder + File.separator + "public", ".htaccess"));
        supportingFiles.add(new SupportingFile("public/favicon.ico", outputFolder + File.separator + "public", "favicon.ico"));
        supportingFiles.add(new SupportingFile("public/index.php", outputFolder + File.separator + "public", "index.php"));
        supportingFiles.add(new SupportingFile("public/robots.txt", outputFolder + File.separator + "public", "robots.txt"));
        supportingFiles.add(new SupportingFile("public/web.config", outputFolder + File.separator + "public", "web.config"));

        /* /routes/ */
        supportingFiles.add(new SupportingFile("routes/api.mustache", outputFolder + File.separator + "routes", "api.php"));
        supportingFiles.add(new SupportingFile("routes/web.mustache", outputFolder + File.separator + "routes", "web.php"));
        supportingFiles.add(new SupportingFile("routes/channels.mustache", outputFolder + File.separator + "routes", "channels.php"));
        supportingFiles.add(new SupportingFile("routes/console.mustache", outputFolder + File.separator + "routes", "console.php"));

        /* /app/Http/Controllers/ */
        supportingFiles.add(new SupportingFile("app/Http/Kernel.php", outputFolder + File.separator + "app" + File.separator + "Http", "Kernel.php"));
        supportingFiles.add(new SupportingFile("app/Http/Controllers/Controller.php", outputFolder + File.separator + "app" + File.separator + "Http" + File.separator + "Controllers", "Controller.php"));
        supportingFiles.add(new SupportingFile("app/Http/Middleware/Authenticate.php", outputFolder + File.separator + "app" + File.separator + "Http" + File.separator + "Middleware", "Authenticate.php"));
        supportingFiles.add(new SupportingFile("app/Http/Middleware/CheckForMaintenanceMode.php", outputFolder + File.separator + "app" + File.separator + "Http" + File.separator + "Middleware", "CheckForMaintenanceMode.php"));
        supportingFiles.add(new SupportingFile("app/Http/Middleware/EncryptCookies.php", outputFolder + File.separator + "app" + File.separator + "Http" + File.separator + "Middleware", "EncryptCookies.php"));
        supportingFiles.add(new SupportingFile("app/Http/Middleware/RedirectIfAuthenticated.php", outputFolder + File.separator + "app" + File.separator + "Http" + File.separator + "Middleware", "RedirectIfAuthenticated.php"));
        supportingFiles.add(new SupportingFile("app