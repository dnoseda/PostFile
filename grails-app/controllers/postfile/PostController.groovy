package postfile
import org.apache.commons.io.*

class PostController {

    def index(){
		    def body = IOUtils.toString(request.inputStream,"UTF-8")

		    render "the total is: "+body.split("\n").count {true}
	    }
}
