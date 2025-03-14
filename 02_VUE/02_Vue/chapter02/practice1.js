class PetHealthManager {
  constructor() {
    this.list = [];
  }
  registerPet(pet1) {
    // [등록] 고양이 - 나비 (예방접종: [종합백신], 건강검진: 2023-03-10)
    console.log(
      `[등록] ${pet1.name} - ${pet1.species} (예방접종: [${pet1.vaccinations}], 건강검진: ${pet1.healthCheckDate})`
    );
    this.list.push(pet1);
  }
  checkHealthStatus() {
    // 3초마다
    // [건강검진 경고] 나비: 1년 이상 건강검진을 받지 않았습니다!
    setInterval(() => {
      for (let i = 0; i < this.list.length; i++) {
        if (this.list[i].alreadyWarned == false) {
          console.log(
            `[건강검진 경고] ${this.list[i].name}: 1년 이상 건강검진을 받지 않았습니다!`
          );
          this.list[i].alreadyWarned = true;
        }
      }
    }, 3000);
  }
}

class Pet {
  constructor(name, species, vaccinations, healthCheckDate, alreadyWarned) {
    this.name = name;
    this.species = species;
    this.vaccinations = vaccinations;
    this.healthCheckDate = healthCheckDate;
    this.alreadyWarned = false;
  }
  addVaccination(name) {
    //     [예방접종 추가] 나비: 광견병
    // [예방접종 중복] 나비: 광견병은 이미 등록되어 있습니다.
    let flag = false;
    for (let i = 0; i < this.vaccinations.length; i++) {
      if (this.vaccinations[i] == name) {
        flag = true;
        console.log(
          `[예방접종 중복] ${this.name}: ${name}은 이미 등록되어 있습니다.`
        );
      }
    }
    if (flag == false) {
      console.log(`[예방접종 추가] ${this.name}: ${name}`);
      this.vaccinations.push(name);
    }
  }
  updateHealthCheckDate(date) {
    this.healthCheckDate = date;
    console.log(`[건강검진 업데이트] ${this.name}: ${date}`);
    console.log('[검사 종료]');
  }
}

// 🐾 시스템 사용 예시
const manager = new PetHealthManager();

// 펫 등록
const pet1 = new Pet('나비', '고양이', ['종합백신'], new Date('2023-03-10'));
manager.registerPet(pet1);

// 예방접종 추가
pet1.addVaccination('광견병');
pet1.addVaccination('광견병'); // 중복 테스트

// 건강 상태 검사 시작
manager.checkHealthStatus();

// // 5초 후 건강검진 업데이트 (경고 초기화 테스트)
setTimeout(() => {
  pet1.updateHealthCheckDate(new Date());
}, 5000);
