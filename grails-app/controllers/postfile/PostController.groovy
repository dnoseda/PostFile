package postfile
import org.apache.commons.io.*

class PostController {

    def index(){
		    def body = IOUtils.toString(request.inputStream,"UTF-8")

		    render "el total es: "+body.split("\n").count {true}
	    }
}
