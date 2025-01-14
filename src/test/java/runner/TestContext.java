package runner;

import pages.BasePage;

public class TestContext {
    private static ThreadLocal<BasePage> page = new ThreadLocal<>();

    public BasePage getPage() {
        return page.get();
    }

    public void setPage(BasePage page) {
        this.page.set(page);
    }
}
