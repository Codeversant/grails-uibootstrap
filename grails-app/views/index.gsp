<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
    <div class="container-fluid">
    <content tag="nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Application Status <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Environment: ${grails.util.Environment.current.name}</a></li>
                <li><a href="#">App profile: ${grailsApplication.config.grails?.profile}</a></li>
                <li><a href="#">App version:
                    <g:meta name="info.app.version"/></a>
                </li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Grails version:
                    <g:meta name="info.app.grailsVersion"/></a>
                </li>
                <li><a href="#">Groovy version: ${GroovySystem.getVersion()}</a></li>
                <li><a href="#">JVM version: ${System.getProperty('java.version')}</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Artefacts <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><a href="#">Controllers: ${grailsApplication.controllerClasses.size()}</a></li>
                <li><a href="#">Domains: ${grailsApplication.domainClasses.size()}</a></li>
                <li><a href="#">Services: ${grailsApplication.serviceClasses.size()}</a></li>
                <li><a href="#">Tag Libraries: ${grailsApplication.tagLibClasses.size()}</a></li>
            </ul>
        </li>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Installed Plugins <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
                    <li><a href="#">${plugin.name} - ${plugin.version}</a></li>
                </g:each>
            </ul>
        </li>
    </content>



    <div id="content" role="main">

        <boots:row>
            <boots:col6>
                <h1>Welcome to Grails</h1>
                    Congratulations, you have successfully started your first Grails application! At the moment
                    this is the default page, feel free to modify it to either redirect to a controller or display
                    whatever content you may choose. Below is a list of controllers that are currently deployed in
                    this application, click on each to execute its default action:
                </p>
            </boots:col6>
            <boots:col6>
                <div id="controllers" role="navigation">
                    <boots:panel title="Available Controllers" type="primary">
                    <ul class="list-group">
                        <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                            <li class="controller list-group-item">
                                <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                            </li>
                        </g:each>
                    </ul>
                    </boots:panel>
                </div>
            </boots:col6>
        </boots:row>

    </div>

    </div>

</body>
</html>
