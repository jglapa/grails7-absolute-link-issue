package grails6.absolute.link.issue

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration

import org.springframework.context.EnvironmentAware
import org.springframework.core.env.Environment
import org.springframework.core.env.MapPropertySource
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.Resource

class Application extends GrailsAutoConfiguration implements EnvironmentAware {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

    @Override
    void setEnvironment(Environment environment) {
        Resource resourceConfig = new FileSystemResource('prod-overrides.groovy')
        def parsedConfig = new ConfigSlurper().parse(resourceConfig.getURL())
        environment.propertySources.addFirst(new MapPropertySource("prod-overrides", parsedConfig))
    }

}
