class BrowserHistory {

    private String[] history;
    private Integer currIndex;

    public BrowserHistory(String homepage) {
        this.currIndex = 0;
        this.history = new String[5000];
        this.history[currIndex] = homepage;
    }

    public void visit(String url) {
        currIndex++;
        this.history[currIndex] = url;

        for (int i = currIndex + 1; i < history.length; i++) {
            history[i] = null;
        }
    }

    public String back(int steps) {
        if (steps > currIndex) {
            currIndex = 0;
        } else {
            currIndex -= steps;
        }
        return history[currIndex];
    }

    public String forward(int steps) {
        for(int i=0;i<steps;i++){
            currIndex++;
            if(history[currIndex]==null){
                currIndex--;
                break;
            }
        }
        return history[currIndex];
    }
}

class BrowserHistoryPro {

    private String[] history;
    private int currIndex;  // 当前位置
    private int lastIndex;  // 最后一个有效位置

    public BrowserHistoryPro(String homepage) {
        this.currIndex = 0;
        this.lastIndex = 0;
        this.history = new String[5000];
        this.history[0] = homepage;
    }

    public void visit(String url) {
        currIndex++;
        history[currIndex] = url;
        lastIndex = currIndex;  // 更新最后位置,无需清空数组
    }

    public String back(int steps) {
        currIndex = Math.max(0, currIndex - steps);
        return history[currIndex];
    }

    public String forward(int steps) {
        currIndex = Math.min(lastIndex, currIndex + steps);
        return history[currIndex];
    }
}
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */