import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
    private byte[] buffer;

    public AsciiCharSequence(byte[] x) {
        this.buffer = x.clone();
    }

    @Override
    public int length() {
        return buffer.length;
    }

    @Override
    public char charAt(int index) {
        return (char)buffer[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        CharSequence res = new AsciiCharSequence(Arrays.copyOfRange(buffer, start, end));
        return res;
    }

    @Override
    public String toString() {
        String res = new String(buffer);
        return res;
    }
}
