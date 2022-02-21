package job;

public class Job {
    String worker;
    String jobType;
    Integer min;

    public Job(String worker, String jobType, Integer min) {
        this.worker = worker;
        this.jobType = jobType;
        this.min = min;
    }

    public String getWorker() {
        return worker;
    }

    public String getJobType() {
        return jobType;
    }

    public Integer getMin() {
        return min;
    }

    @Override
    public String toString() {
        return this.getWorker() + "." + this.getJobType() +
                "." + this.getMin();

    }
}
