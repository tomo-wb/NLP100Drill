
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author TomoyaMizumoto
 */
public class ExtensionBufferedReader extends BufferedReader {
    Reader in;
    public ExtensionBufferedReader(Reader in) {
        super(in);
    }
    public ExtensionBufferedReader(Reader in, int sz) {
        super(in, sz);
    }
    
    @Override
    public String readLine() throws IOException {
        int num = 0;
        StringBuilder strBld = new StringBuilder();
        try {
            while ((num = this.read()) >= 0) {
                switch ((char) num) {
                case '\r':
                    strBld.append(" ");
                    num = this.read();
                    strBld.append((char) num);
                    break;
                case '\n':
                    return strBld.toString();
                default:
                    strBld.append((char) num);
                    break;
                }
            }
        }catch (IOException e) {
            throw e;
        }
        
        if (strBld.length() == 0) {
            return null;
        } else {
            return strBld.toString();
        }
    }
}
