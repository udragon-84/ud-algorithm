package algorithm.lv3;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 프로그래머스 다단계 판매
 * https://school.programmers.co.kr/learn/courses/30/lessons/77486
 */
public class MultiLevelSeller {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        List<MultiLevelSellerDomain> multiLevelSellerDomainList = this.createMultiLevelSellerDomainList(enroll, seller, amount);
        this.updateMultiLevelSellerParent(multiLevelSellerDomainList, referral);

        multiLevelSellerDomainList.forEach(domain -> {
            int charge = domain.getSalesPrice() / 10;
            int myPrice = domain.getSalesPrice() - charge;
            domain.setSalesPrice(myPrice);
            this.updateParentAddPrice(domain.getParent(), charge);
            System.out.println(domain);
        });
        return multiLevelSellerDomainList.stream().mapToInt(domain -> domain.getAddPrice() + domain.getSalesPrice()).toArray();
    }

    private void updateParentAddPrice(MultiLevelSellerDomain parent, int parentCharge) {
        if (Objects.isNull(parent)) return;
        int charge = parentCharge / 10;
        int myPrice = parentCharge - charge;
        parent.setAddPrice(parent.getAddPrice() + myPrice);
        updateParentAddPrice(parent.getParent(), charge);
    }

    private void updateMultiLevelSellerParent(List<MultiLevelSellerDomain> multiLevelSellerDomainList, String[] referral) {
        for (int i = 0; i < multiLevelSellerDomainList.size(); i++) {
            MultiLevelSellerDomain multiLevelSellerDomain = multiLevelSellerDomainList.get(i);
            String parent = referral[i];
            multiLevelSellerDomain.setParent(multiLevelSellerDomainList.stream()
                    .filter(domain -> domain.getName().equals(parent))
                    .findAny()
                    .orElse(null));
        }
    }

    // 기본정보를 먼저 생성
    private List<MultiLevelSellerDomain> createMultiLevelSellerDomainList(String[] enroll, String[] seller, int[] amount) {
       return Arrays.stream(enroll)
               .map(sellerUser -> {
                 MultiLevelSellerDomain domain = new MultiLevelSellerDomain(sellerUser);
                 int sellerUserIndex = this.findSellerUser(seller, sellerUser);
                 if (sellerUserIndex != -1) {
                     domain.setAddPrice(0);
                     domain.setSalesPrice(amount[sellerUserIndex] * 100);
                 }
                 return domain;
               }).collect(Collectors.toList());
    }

    public int findSellerUser(String[] seller, String target) {
        if (seller == null) return -1;
        for (int i = 0; i < seller.length; i++) {
            if (seller[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MultiLevelSeller multiLevelSeller = new MultiLevelSeller();
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        int[] result = multiLevelSeller.solution(enroll, referral, seller, amount);
        System.out.println(Arrays.toString(result));
    }

    public static class MultiLevelSellerDomain {
        private String name;
        private int addPrice;
        private int salesPrice;
        private MultiLevelSellerDomain parent;

        public MultiLevelSellerDomain(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getSalesPrice() {
            return salesPrice;
        }

        public void setSalesPrice(int salesPrice) {
            this.salesPrice = salesPrice;
        }

        public int getAddPrice() {
            return addPrice;
        }

        public void setAddPrice(int addPrice) {
            this.addPrice = addPrice;
        }

        public void setName(String name) {
            this.name = name;
        }

        public MultiLevelSellerDomain getParent() {
            return parent;
        }

        public void setParent(MultiLevelSellerDomain parent) {
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "MultiLevelSellerDomain{" +
                    "name='" + name + '\'' +
                    ", addPrice=" + addPrice +
                    ", salesPrice=" + salesPrice +
                    ", parent=" + parent +
                    '}';
        }
    }
}
