package grails6.absolute.link.issue

import grails.core.GrailsApplication
import grails.web.mapping.LinkGenerator

class MakeLinkController {

    LinkGenerator grailsLinkGenerator
    GrailsApplication grailsApplication

    def index() {
        String link2 = grailsLinkGenerator.link(
                absolute: true,
                controller: 'MakeLink',
                action: 'index',
                id: 1
        )

        render """
Link : ${link2} </br>
serverURL: ${grailsApplication.config.grails.serverURL}
"""
    }
}
