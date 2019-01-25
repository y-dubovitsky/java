package io20.bytes.example5;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class SequenceIS {
    class Files implements Enumeration {

        List<File> files = new ArrayList<>();
        int count = 0;

        void addElement(File file) {
            files.add(file);
            count++;
        }

        @Override
        public boolean hasMoreElements() {
            return false;
        }

        @Override
        public Object nextElement() {
            return null;
        }
    }
}
