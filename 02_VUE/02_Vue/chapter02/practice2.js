class Item {
  constructor(name, type, stock, alreadyWarned) {
    this.name = name;
    this.type = type;
    this.stock = stock;
    this.alreadyWarned = alreadyWarned;
  }
}

class InventoryManager {
  constructor() {
    this.list = [];
  }
  addItem(item) {
    // [추가] 사료 - 고급 고양이 사료 (재고: 10개)
    item.alreadyWarned = false;
    this.list.push(item);
    console.log(`[추가] ${item.type} - ${item.name} (재고: ${item.stock}개)`);
  }
  updateStock(name, newStock) {
    if (newStock < 0) {
      console.log(`[업데이트 오류] 재고는 0 이상이어야 합니다.`);
    } else {
      for (let i = 0; i < this.list.length; i++) {
        if (this.list[i].name == name) {
          this.list[i].stock = newStock;
          console.log(`[업데이트] ${name} 재고: ${newStock}`);
          if (newStock < 5) {
            this.list[i].alreadyWarned = true;
            console.log(`[재고 부족 경고] ${name}: 재고가 5개 미만입니다!`);
          }
        }
      }
    }
  }
  checkStock() {
    for (let i = 0; i < this.list.length; i++) {
      if (this.list[i].alreadyWarned == true) {
        setTimeout(() => {
          console.log(
            `[재고 부족 경고] ${this.list[i].name}: 재고가 5개 미만입니다!`
          );
          console.log(`[재고 검사 종료]`);
          this.list[i].alreadyWarned = false;
        }, 5000);
      }
    }
  }
}

// 🐾 시스템 사용 예시
const inventory = new InventoryManager();

// 아이템 등록
const item1 = new Item('고급 고양이 사료', '사료', 10);
inventory.addItem(item1);

// 재고 업데이트
inventory.updateStock('고급 고양이 사료', 4); // 5개 미만 → 경고 발생
inventory.updateStock('고급 고양이 사료', -1); // 음수 입력 → 오류 발생

// 재고 상태 검사 시작 (5초 후 종료)
inventory.checkStock();
