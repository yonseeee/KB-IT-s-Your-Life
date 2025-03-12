// ES 모듈 시스템의 내보내기 방식(export default 버전)
// 기본 내보내기 방식은 파일당 하나씩만 가능
const goodbye = (name) => {
  console.log(`${name}님, 안녕히 가세요.`);
};

export default goodbye;
