package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.Base64;
/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        //5.11 
        String input = "Hello Big World"; // 48656c6c6f20576f726c64 vs
		// 48656c6c6f2042696720576f726c64 gets bigger 
		String hexs = "010203040506"; // Hexstring for 5.13.2
		String hexstring = "4d6f64756c652032"; // Hexstring for 5.12
		String input1 = "Hello World";
		Hex hex = new Hex();
		byte[] bytearray = (byte[]) hex.decode(hexs); 
		String Base64string = "U29mdHdhcmUgU3lzdGVtcw=="; // For 5.13.3
		
		System.out.println(Hex.encodeHexString(input.getBytes()));
		// 5.12
		System.out.println(new String(Hex.decodeHex(hexstring.toCharArray())));
		// 5.13.1: Encode it in Base64
		System.out.println(Base64.encodeBase64String(input1.getBytes()));
		// 5.13.2: Take hexs and decode it to a byte array
		System.out.println(Base64.encodeBase64String(bytearray));
		//5.13.2 length
		System.out.println((Base64.encodeBase64String(bytearray)).length()+"blabla");
		// 5.13.3: Decode the string 'Base64String'
		System.out.println(new String(Base64.decodeBase64(Base64string.getBytes())));
		// 5.13.4
		String result = "";
		for (int i = 0; i < 9; i++) {
		result = result + "a";
		System.out.println(Base64.encodeBase64String(result.getBytes()));
}
        
    }
}
