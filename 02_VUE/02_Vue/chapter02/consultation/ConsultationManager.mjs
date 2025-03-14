class ConsultationManager {
  constructor() {
    this.list = [];
  }
  registerConsultation(customer) {
    for (let i = 0; i < this.list.length; i++) {
      if (this.list[i].name == customer.name) {
        console.log(
          `[상담 중복 오류] ${customer.name}: 이미 등록된 상담 기록입니다.`
        );
        return;
      } else if (customer.phone.substring(0, 3) != '010') {
        console.log(
          `[상담 등록 오류] ${customer.name}: 잘못된 전화번호 형식입니다.`
        );
        return;
      }
    }
    this.list.push(customer);
    console.log(`[상담 등록] ${customer.name} - 선호 펫:${customer.pet}`);
  }
  autoEndConsultation() {
    setTimeout(() => {
      for (let i = 0; i < this.list.length; i++) {
        console.log(`[저장 완료] ${this.list[i].name} 상담 기록 저장 완료!`);
      }
      console.log('[상담 기록 저장 완료]');
    }, 5000);
  }
}

export { ConsultationManager };
