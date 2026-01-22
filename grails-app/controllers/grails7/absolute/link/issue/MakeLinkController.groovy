package grails7.absolute.link.issue

import grails.web.mapping.LinkGenerator

class MakeLinkController {

    LinkGenerator grailsLinkGenerator

    def index() {

        String link
        Thread.start {
            try {
                link = grailsLinkGenerator.link(
                        absolute: true,
                        controller: 'MakeLink',
                        action: 'index',
                        id: 1
                )
            } catch (Exception e) {
                e.printStackTrace()
            }
        }


        String link2 = grailsLinkGenerator.link(
                absolute: true,
                controller: 'MakeLink',
                action: 'index',
                id: 1
        )

        render link + link2
    }
}
