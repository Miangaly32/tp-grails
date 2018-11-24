package tp.grails

import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import groovy.transform.CompileStatic

@SuppressWarnings('GrailsStatelessService')
@CompileStatic
class UploadUserFeaturedImageService implements GrailsConfigurationAware {

    UserDataService userDataService

    String cdnFolder
    String cdnRootUrl

    @Override
    void setConfiguration(Config co) {
        cdnFolder = co.getRequiredProperty('grails.guides.cdnFolder')
        cdnRootUrl = co.getRequiredProperty('grails.guides.cdnRootUrl')
    }

    @SuppressWarnings('JavaIoPackageAccess')
    Utilisateur uploadFeatureImage(FeaturedImageCommand cmd) {

        String filename = cmd.featuredImageFile.originalFilename
        String folderPath = "C:/wamp/www/${cdnFolder}"
        File folder = new File(folderPath)
        if ( !folder.exists() ) {
            folder.mkdirs()
        }
        String path = "${folderPath}/${filename}"
        cmd.featuredImageFile.transferTo(new File(path))

        String featuredImageUrl = "${filename}"

        Utilisateur utilisateur = userDataService.updateFeaturedImageUrl(cmd.id, cmd.version,featuredImageUrl)

        if ( !utilisateur || utilisateur.hasErrors() ) {
            File f = new File(path)
            f.delete()
        }
        utilisateur
    }

}
