package hello.hellospring.controller1;


public class TestDto {

    private TestDetailDto testDetailDto;

    public TestDetailDto getTestDetailDto() {
        return testDetailDto;
    }

    public void setTestDetailDto(TestDetailDto testDetailDto) {
        this.testDetailDto = testDetailDto;
    }

    public TestDto(TestDetailDto testDetailDto) {
        this.testDetailDto = testDetailDto;
    }
}
