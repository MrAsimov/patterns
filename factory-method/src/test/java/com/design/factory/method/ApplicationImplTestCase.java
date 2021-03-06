/*
 * MIT License
 *
 * Copyright (c) 2017 Andy Holst
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.design.factory.method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationImplTestCase {
    @Test
    public void testApplicationTest() {
        Application application = new ApplicationImpl();

        assertNull(application.getCurrentDocument());
        assertEquals(true, application.getDocuments().isEmpty());

        Document document = application.createDocument();

        application.openDocument(); // sonar test coverage

        assertNull(document.getState());

        assertNotNull(document);

        application.newDocument();

        assertNotNull(application.getCurrentDocument());

        assertEquals(1, application.getDocuments().size());

        assertEquals(application.getCurrentDocument().hashCode(), application.getDocuments().get(0).hashCode());

        application.openDocument();

        assertEquals(DocumentImpl.DocumentEnum.OPEN, DocumentImpl.DocumentEnum.valueOf(application.getCurrentDocument()
                .getState()));

        application.newDocument();

        assertNotNull(application.getCurrentDocument());

        assertEquals(2, application.getDocuments().size());

        assertEquals(application.getCurrentDocument().hashCode(), application.getDocuments().get(1).hashCode());

        application.openDocument();

        assertEquals(DocumentImpl.DocumentEnum.OPEN, DocumentImpl.DocumentEnum.valueOf(application.getCurrentDocument()
                .getState()));
    }
}