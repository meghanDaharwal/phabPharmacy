package ServletCommunications;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class GetCustomers {
    Customers customers;
    public GetCustomers(){
        String message = String.valueOf(12);
        byte[] body = message.getBytes(StandardCharsets.UTF_8);
        URL myURL = null;
        try {
            myURL = new URL("https://phabpharmacy.herokuapp.com/customers");
            HttpURLConnection conn = null;
            conn = (HttpURLConnection) myURL.openConnection();
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
            this.customers = new Customers();
            while ((inputLine = bufferedReader.readLine()) != null) {
                Gson gson = new Gson();
                Customers c=gson.fromJson(inputLine, Customers.class);
                this.customers.setCustomers(c.getCustomers());
            }
            bufferedReader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public Customers getCustomers() {
        return customers;
    }

}
