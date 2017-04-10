/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countingtexthandler;

import com.aliasi.corpus.ObjectHandler;

/**
 *
 * @author Anwar
 */
public class CountText implements ObjectHandler<CharSequence>{
    private long numChars=0L;
    private long numSeqs=0L;
    @Override
    public void handle(CharSequence cs) {
        ++numSeqs;
        numChars+=cs.length();
    }
    @Override
    public String toString(){
        return "#Seq: "+numSeqs+" #chars: "+numChars;
    }
}
