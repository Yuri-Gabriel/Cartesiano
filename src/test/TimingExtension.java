package test;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TimingExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {
    private long start;

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        start = System.nanoTime();
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        long end = System.nanoTime();
        System.out.println(context.getDisplayName() + " durou " + (end - start) / 1_000_000 + " ms");
    }
}
