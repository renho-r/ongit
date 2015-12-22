package com.renho.chapter9.executatserver;

public class ClassModifier {
	 
    private static final int CONSTANT_POOL_COUNT_INDEX = 8;
    private static final int   CONSTANT_UTF8_INFO        = 1;
    private static final int[] CONSTANT_ITEM_LENGTH      = { -1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5 };
    private static final int   u1                        = 1;
    private static final int   u2                        = 2;
    private byte[]             classByte;
 
    public ClassModifier(byte[] classByte){
        this.classByte = classByte;
    }
 
    public int getConstantPoolCount() {
        return ByteUtil.byte2Int(classByte, CONSTANT_POOL_COUNT_INDEX, u2);
    }
 
    public byte[] modify(String oldStr, String newStr) {
        int cpc = getConstantPoolCount();
        int offset = CONSTANT_POOL_COUNT_INDEX + u2;
        for (int i = 0; i < cpc; i++) {
            int tag = ByteUtil.byte2Int(classByte, offset, u1);
            if (tag == CONSTANT_UTF8_INFO) {
                int len = ByteUtil.byte2Int(classByte, offset + u1, u2);
                offset += (u1 + u2);
                String str = ByteUtil.byte2String(classByte, offset, len);
                if (str.equalsIgnoreCase(oldStr)) {
                    byte[] strBytes = ByteUtil.string2Bytes(newStr);
                    byte[] strLen = ByteUtil.int2Bytes(newStr.length(), u2);
                    classByte = ByteUtil.byteReplace(classByte, offset - u2, u2, strLen);
                    classByte = ByteUtil.byteReplace(classByte, offset, len, strBytes);
                    return classByte;
                } else {
                    offset += len;
                }
            } else {
                offset += CONSTANT_ITEM_LENGTH[tag];
            }
        }
        return classByte;
    }
}
