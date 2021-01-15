package ServletCommunications;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

/*  This class takes a date in it's constructor in order to perform the servlet
    communication required to check the profit made at that date.
    It makes a single post to the accessProfit servlet, the response to which
    is the profit on the required date. Logs beginning with CP come from this class */
public class CheckUser {
    private static final Logger log= Logger.getLogger(CheckUser.class.getName());
    public String check;
    public CheckUser(String name, String password){
        String message = name + " " + password;
        byte[] body = message.getBytes(StandardCharsets.UTF_8);
        URL myURL = null;
        try {
            myURL = new URL("https://phabpharmacy.herokuapp.com/checkUser");
            HttpURLConnection conn = null;
            conn = (HttpURLConnection) myURL.openConnection();
            log.info("CP: connection made");
// Set up the header
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "text/html");
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("Content-Length", Integer.toString(body.length));
            conn.setDoOutput(true);
// Write the body of the request
            try (OutputStream outputStream = conn.getOutputStream()) {
                outputStream.write(body, 0, body.length);
            }
            BufferedReader bufferedReader = new BufferedReader(new
                    InputStreamReader(conn.getInputStream(), "utf-8"));
            String inputLine;
// Read the body of the response
            while ((inputLine = bufferedReader.readLine()) != null) {
                System.out.println(inputLine);
                this.check = inputLine;
            }
            bufferedReader.close();

        } catch (MalformedURLException e) {
            log.severe("RD: problem with URL");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            log.severe("RD: protocol error, such as problem with TCP");
            e.printStackTrace();
        } catch (IOException e) {
            log.severe("RD: an i/o error has occured");
            e.printStackTrace();
        }

    }
    public String getCheck() {
        return check;
    }
}
