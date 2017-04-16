import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by jkonarze on 4/4/17.
 */
public class PropertiesBasic extends Properties {

	@Override
	public void store(OutputStream out, String comments) throws IOException {
		customStore0(new BufferedWriter(new OutputStreamWriter(out, "UTF-8")));
	}

	/**
	 * Modified version of private method store0 from Properties. The main goal is to avoid escaping special
	 * characters which modifies the html escape sequence.
	 *
	 * @param bw
	 * @throws IOException
	 */
	private void customStore0(BufferedWriter bw)
			throws IOException {
		bw.write("#" + new Date().toString());
		bw.newLine();
		synchronized (this) {
			for (Enumeration e = keys(); e.hasMoreElements();) {
				String key = (String) e.nextElement();
				String val = (String) get(key);
				bw.write(key + "=" + val);
				bw.newLine();
			}
		}
		bw.flush();
	}

}
