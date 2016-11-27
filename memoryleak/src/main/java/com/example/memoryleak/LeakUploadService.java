package com.example.memoryleak;

import android.util.Log;

import com.squareup.leakcanary.AnalysisResult;
import com.squareup.leakcanary.DisplayLeakService;
import com.squareup.leakcanary.HeapDump;

/**
 * Created by gaozhuo on 2016/10/19.
 */

public class LeakUploadService extends DisplayLeakService {
    @Override
    protected void afterDefaultHandling(HeapDump heapDump, AnalysisResult result, String leakInfo) {
        super.afterDefaultHandling(heapDump, result, leakInfo);
        Log.d("gaozhuo", "heapDump=" + heapDump.heapDumpFile);
        Log.d("gaozhuo", "leakInfo=" + leakInfo);
    }
}
