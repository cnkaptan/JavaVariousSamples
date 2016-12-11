package Thread.book.Java_Threads_2nd_Edition.chapter_3;/*
 *
 * Copyright (c) 1997-1999 Scott Oaks and Henry Wong. All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL purposes and
 * without fee is hereby granted.
 *
 * This sample source code is provided for example only,
 * on an unsupported, as-is basis. 
 *
 * AUTHOR MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. AUTHOR SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 * THIS SOFTWARE IS NOT DESIGNED OR INTENDED FOR USE OR RESALE AS ON-LINE
 * CONTROL EQUIPMENT IN HAZARDOUS ENVIRONMENTS REQUIRING FAIL-SAFE
 * PERFORMANCE, SUCH AS IN THE OPERATION OF NUCLEAR FACILITIES, AIRCRAFT
 * NAVIGATION OR COMMUNICATION SYSTEMS, AIR TRAFFIC CONTROL, DIRECT LIFE
 * SUPPORT MACHINES, OR WEAPONS SYSTEMS, IN WHICH THE FAILURE OF THE
 * SOFTWARE COULD LEAD DIRECTLY TO DEATH, PERSONAL INJURY, OR SEVERE
 * PHYSICAL OR ENVIRONMENTAL DAMAGE ("HIGH RISK ACTIVITIES").  AUTHOR
 * SPECIFICALLY DISCLAIMS ANY EXPRESS OR IMPLIED WARRANTY OF FITNESS FOR
 * HIGH RISK ACTIVITIES.
 */


import java.io.*;
import java.net.*;

public class AsyncReadSocket extends Thread {
	private Socket s;
	private StringBuffer result;

	public AsyncReadSocket(Socket s) {
		this.s = s;
		result = new StringBuffer();
	}

	public void run() {
		DataInputStream is = null;
		try {
			is = new DataInputStream(s.getInputStream());
		} catch (Exception e) {

		}
		while (true) {
			try {
				char c = is.readChar();
				appendResult(c);
			} catch (Exception e) {

            }
		}
	}

	// Get the string already read from the socket so far.
	// This method is used by the Applet thread to obtain the data
	// in a synchronous manner.
	public synchronized String getResult() {
		String retval = result.toString();
		result = new StringBuffer();
		return retval;
	}

	// Put new data into the buffer to be returned
	// by the getResult method
	public synchronized void appendResult(char c) {
		result.append(c);
	}

    /**
     * When you have two threads that are reading and writing to the same 'resource',
     * say a variable named foo, you need to ensure that these threads access the variable in an atomic way.
     *
     *
     * 1. The applet thread enters the getResult() method.
     * 2. The applet thread assigns retval to a new string created from the result StringBuffer.
     * 3. The socket thread returns from the readChar() method.
     * 4. The socket thread calls the appendResult() method to append the character to the result StringBuffer.
     * 5. The applet thread assigns result to a new (empty) StringBuffer.
     *
     * The data that was appended to the StringBuffer in step 4 is now lost: it wasn't retrieved by the applet
     * thread at step 2, and the applet thread discards the old StringBuffer in step 5.
     */
}
