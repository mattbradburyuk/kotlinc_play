
import java.net.URL
import java.net.URLClassLoader


var cl = ClassLoader.getSystemClassLoader()

var urls = ((URLClassLoader)cl).getURLs()

for( url in  urls){
	System.out.println(url.getFile())
}
