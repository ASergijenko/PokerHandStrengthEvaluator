package com.project;

import com.project.pokerType.FiveCardDraw;
import com.project.pokerType.Omaha;
import com.project.pokerType.Texas;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplicationTest {

    private Texas texas;
    private Omaha omaha;
    private FiveCardDraw fiveCardDraw;

    @Before
    public void setUp() {
        texas = new Texas();
        omaha = new Omaha();
        fiveCardDraw = new FiveCardDraw();
    }

    @Test
    public void threeOfAKindTwoTimesEquals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("Ac4d=Ad4s 5d6d As9s KhKd", texas.calculate(("4cKs4h8s7s Ad4s Ac4d As9s KhKd 5d6d")));
    }

    @Test
    public void pairFlush() {
         Application.typeOfPoker = "texas-holdem";
         assertEquals("KdKs 9hJh", texas.calculate(("2h3h4h5d8d KdKs 9hJh ")));
    }

    @Test
    public void fourOfAKindTwoTimesEquals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("KcKs=QsQc", texas.calculate(("AsAcAhAdKd KcKs QsQc")));
    }

    @Test
    public void fourOfAKindTwoTimesNotEquals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("8s8h AhAs", texas.calculate(("AdAc8d8c7c AhAs 8s8h")));
    }

    @Test
    public void straightEquals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("7cAc=Js5s", texas.calculate(("7s4d6c3h5h 7cAc Js5s")));
    }

    @Test
    public void pairTwoPairs() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("7c8c 8s8h", texas.calculate(("TsJdQcThAh 7c8c 8s8h")));
    }

    @Test
    public void flushTwoFullHouses() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("Jh9h As5d 7d8s", texas.calculate(("5s7h5hAh7s As5d 7d8s Jh9h")));
    }

    @Test
    public void twoFullHousesEquals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("7s7d=TcKs", texas.calculate(("JsJd8c8h8s 7s7d TcKs")));
    }

    @Test
    public void twoTwoPairs() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("Ad9s Ah5d", texas.calculate(("3s7d3c5h7h Ah5d Ad9s")));
    }

    @Test
    public void pairsEquals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("Ad9s=Ah5d", texas.calculate(("3sTd3hKc2h Ah5d Ad9s")));
    }

    @Test
    public void pairsNotEquals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("AdQs AhKd", texas.calculate(("3s7d3hJc2h AhKd AdQs")));
    }

    @Test
    public void twoPairsFlush() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("AdAc AhAs", texas.calculate(("ThJhKhJc2h AhAs AdAc")));
    }

    @Test
    public void threeOfAKindStraight() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("3h3s AdQs", texas.calculate(("ThJdKh3c2h 3h3s AdQs")));
    }

    @Test
    public void fourOfAKindRoyal() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("3h3s AsQs", texas.calculate(("TsJs3d3cKs 3h3s AsQs")));
    }

    @Test
    public void threeRoyals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("2c3s=3h3s=4c5s", texas.calculate(("TsJsAsQsKs 3h3s 2c3s 4c5s")));
    }

    @Test
    public void twoFlushes() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("8s9s 7sTs", texas.calculate(("2sJs3s3c2h 8s9s 7sTs")));
    }

    @Test
    public void twoTwoPairsNotEquals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("KhJc KdQs", texas.calculate(("AdKs5cJhQd KdQs KhJc")));
    }

    @Test
    public void twoTwoPairs2() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("7h7c KcQc", texas.calculate(("8d8s9cTh9s KcQc 7h7c")));
    }

    @Test
    public void twoStraights() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("7h7c QdAc", texas.calculate(("6d8sJc9hTs QdAc 7h7c")));
    }

    @Test
    public void pairStraight() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("AdAc 7h7c", texas.calculate(("6d8sJc9hTs AdAc 7h7c")));
    }

    @Test
    public void twoTwoPairsEquals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("Ad9d=As3s", texas.calculate(("Kc9sThKdTs As3s Ad9d")));
    }

    @Test
    public void straightAndFlush() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("AdQs Ah3h", texas.calculate(("ThJdKhJc2h Ah3h AdQs")));
    }

    @Test
    public void twoFlushesNotEquals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("8s9s 6sTs", texas.calculate(("2sKs3sAsJs 8s9s 6sTs")));
    }

    @Test
    public void twoFlushesEquals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("2s6s=3s7s", texas.calculate(("9sKs8sAsJs 2s6s 3s7s")));
    }

    @Test
    public void pairAndPair() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("KhJc KdQs", texas.calculate(("8dKs5c3h9s KdQs KhJc")));
    }

    @Test
    public void twoFullHouses2() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("AdAc KhTc", texas.calculate(("KdKsJcJhJs AdAc KhTc")));
    }

    @Test
    public void twoStraightsNotEquals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("7h7c KdQc", texas.calculate(("7d8sJcTs9h KdQc 7h7c")));
    }

    @Test
    public void pairAndPair2() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("KhJc KdQs", texas.calculate(("2d5s5c9hTs KdQs KhJc")));
    }

    @Test
    public void twoStraightsEquals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("4d5d=6s7c", texas.calculate(("6h3d5c7s4s 6s7c 4d5d")));
    }

    @Test
    public void pairs() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("3cKh KdQh", texas.calculate(("2h5c8sAsKc KdQh 3cKh")));
    }

    @Test
    public void pairsTwoPairsTwoEquals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("7s3c 8h3d 9c7d AsKd 9h9s TcJd=Ts3s 4dQs", texas.calculate(("5d5h6hQdTd 7s3c Ts3s 9c7d 8h3d 9h9s AsKd 4dQs TcJd")));
    }

    @Test
    public void twoStraightFlushes() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("7c8h Qc4h", texas.calculate(("JcTc9c8cAd Qc4h 7c8h")));
    }

    @Test
    public void twoFourOfAKind() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("8s8h AhAs", texas.calculate(("AdAc8d8c7c AhAs 8s8h")));
    }

    @Test
    public void twoFourOfAKind2() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("9s8d JsTd", texas.calculate(("AdAcAhAs7c 9s8d JsTd")));
    }

    @Test
    public void twoThreeOfAKind() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("TsTh AdAc", texas.calculate(("Ah4h2d7sTc TsTh AdAc")));
    }

    @Test
    public void twoThreeOfAKind2() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("Qh7s QcJh", texas.calculate(("Ah4hAsAc5d QcJh Qh7s")));
    }

    @Test
    public void twoThreeOfAKind3() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("3cJs Td9c", texas.calculate(("QcQhTs8s3h Td9c 3cJs")));
    }

    @Test
    public void twoTwoPairs3() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("Td9c TcJs", texas.calculate(("QcQhTs8s3h Td9c TcJs")));
    }

    @Test
    public void twoHighCards() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("Js4d 2cQh", texas.calculate(("AhKs8s6d5c 2cQh Js4d")));
    }

    @Test
    public void twoHighCards2() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("7dJc KsQh", texas.calculate(("AsTd8d6c4h KsQh 7dJc")));
    }

    @Test
    public void highPairThreeFLush() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("JdTd AcAh 6h6d 2cJc", texas.calculate(("KdQd8c6c5c AcAh JdTd 6h6d 2cJc")));
    }

    @Test
    public void fullHouses() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("9s4s 7c7d", texas.calculate(("5cAcAdAh5h 7c7d 9s4s")));
    }

    @Test
    public void twoStraightFlushes2() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("5c4d TcQs", texas.calculate(("6c7c8c9cKd TcQs 5c4d")));
    }

    @Test
    public void twoStraightFlushes2Equals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("5c4d=TcQs", texas.calculate(("5h6h7h8h9h TcQs 5c4d")));
    }

    @Test
    public void twoFourOfAKind3() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("KhKd Ac2c", texas.calculate(("QdQsQhQc5d KhKd Ac2c")));
    }

    @Test
    public void twoFourOfAKind3Equals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("Ac2c=KhAd", texas.calculate(("QdQsQhQc5d KhAd Ac2c")));
    }

    @Test
    public void twoFlushes2() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("2d3s 3d6s", texas.calculate(("AsKsTs7s5s 2d3s 3d6s")));
    }

    @Test
    public void twoStraights2() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("ThJs TcQh", texas.calculate(("8s9cJd7h2s ThJs TcQh")));
    }

    @Test
    public void twoTwoPairs4() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("Kh9s TsKd", texas.calculate(("Ks9cTh2d6c TsKd Kh9s")));
    }

    @Test
    public void threePairsNotEquals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("QhQd KhTc Ah3s", texas.calculate(("AdKd5s9c8c KhTc Ah3s QhQd")));
    }

    @Test
    public void twoPairsNotEquals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("4c4h Ac9d", texas.calculate(("5d5c6c6hKd 4c4h Ac9d")));
    }

    @Test
    public void twoPairsEquals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("4c4h=8c9d", texas.calculate(("5d5c6c6hKd 4c4h 8c9d")));
    }

    @Test
    public void twoFlushRoyals() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("6dKd=Ad5d", texas.calculate(("TsJsQsKsAs Ad5d 6dKd")));
    }

    @Test
    public void twoStraightFlushes3() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("6s6d JsJd", texas.calculate(("8s9sTs7s2d 6s6d JsJd")));
    }

    @Test
    public void twoStraightsNotEquals2() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("6s6d JsJd", texas.calculate(("8s9dTs7h2d 6s6d JsJd")));
    }

    @Test
    public void twoStraights3() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("6s6h=JsJd", texas.calculate(("2s3d4s5h6d 6s6h JsJd")));
    }

    @Test
    public void twoStraights4() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("As8h 6sJd", texas.calculate(("2s3d4s5h8d As8h 6sJd")));
    }

    @Test
    public void twoStraightFlushes4() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("As8h 6sJd", texas.calculate(("2s3s4s5s8d As8h 6sJd")));
    }

    @Test
    public void twoFullHouses() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("8sJd Qh7h", texas.calculate(("8d8h4sQsQd Qh7h 8sJd")));
    }

    @Test
    public void twoFUllHouses2() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("Qh7h Qc9d", texas.calculate(("8d8h9sQsQd Qh7h Qc9d")));
    }

    @Test
    public void twoFullHouses3() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("9c7h=Jc9d", texas.calculate(("8d8h8sQsQd 9c7h Jc9d")));
    }

    @Test
    public void pairsTwoPairsThree() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("2cJc Kh4h=Ks4c Kc7h KdJs 6h7d 2hAh", texas.calculate(("5c6dAcAsQs Ks4c KdJs 2hAh Kh4h Kc7h 6h7d 2cJc")));
    }

    @Test
    public void highCardsPairs() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("Jc6s Qs9h 3cKh KdQh", texas.calculate(("2h5c8sAsKc Qs9h KdQh 3cKh Jc6s")));
    }

    @Test
    public void highCardsPairsTwoPairsThree() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("9h7h 2dTc KcAs 7sJd TsJc Qh8c 5c4h", texas.calculate(("3d4s5dJsQd 5c4h 7sJd KcAs 9h7h 2dTc Qh8c TsJc")));
    }

    @Test
    public void fix1() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("Ac5d=As4c", texas.calculate("5s8cAhThTs As4c Ac5d"));
    }

    @Test
    public void fix1reverse() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("Ac5d=As4c", texas.calculate("5s8cAhThTs Ac5d As4c"));
    }

        @Test public void testOmaha2(){ Application.typeOfPoker = "omaha-holdem";assertEquals("2c2d3c3d 4c4d5c5d 6c6d7c7h", omaha.calculate(("7s7dKsKhQs 2c2d3c3d 4c4d5c5d 6c6d7c7h"))); }
        @Test public void testOmaha3(){ Application.typeOfPoker = "omaha-holdem";assertEquals("Qc8dAd6c KsAsTcTs Js2dKd8c 7dQsAc5d Jh2h3c9c", omaha.calculate(("3d3s4d6hJc Js2dKd8c KsAsTcTs Jh2h3c9c Qc8dAd6c 7dQsAc5d")));}
        @Test public void testOmaha4(){ Application.typeOfPoker = "omaha-holdem";assertEquals("4d3h2hQh 4c8s9d5d", omaha.calculate(("QdTd3sJcTs 4d3h2hQh 4c8s9d5d")));}
        @Test public void testOmaha5(){ Application.typeOfPoker = "omaha-holdem";assertEquals("AcAs5h2c KcQcJd7d", omaha.calculate(("KhQdQsKs5d KcQcJd7d AcAs5h2c")));}
        @Test public void testOmaha6(){ Application.typeOfPoker = "omaha-holdem";assertEquals("KdKs7h5d AhJc5h4c", omaha.calculate(("4h7s4d2h5c KdKs7h5d AhJc5h4c")));}
        @Test public void testOmaha7(){ Application.typeOfPoker = "omaha-holdem";assertEquals("Td9s8d4c AsJcJs3c", omaha.calculate(("4s5cQc3hQh AsJcJs3c Td9s8d4c")));}
        @Test public void testOmaha8(){ Application.typeOfPoker = "omaha-holdem";assertEquals("8h7d5s2d AcKhTs8c", omaha.calculate(("6c4s7c9c9d 8h7d5s2d AcKhTs8c")));}
        @Test public void testOmaha9(){ Application.typeOfPoker = "omaha-holdem";assertEquals("KdTdTs2s AsKcKs9d", omaha.calculate(("9c8cKh3sQs AsKcKs9d KdTdTs2s")));}
        @Test public void testOmaha10(){ Application.typeOfPoker = "omaha-holdem";assertEquals("8h7d5s2d AcKhTs8c", omaha.calculate(("6c4s7c9c9d 8h7d5s2d AcKhTs8c")));}
        @Test public void testOmaha11(){ Application.typeOfPoker = "omaha-holdem";assertEquals("AcKhTc2d AhAsJs6h", omaha.calculate(("7h8dKcTh9h AhAsJs6h AcKhTc2d")));}
        @Test public void testOmaha12(){ Application.typeOfPoker = "omaha-holdem";assertEquals("Ac7c5c2c Kh6h3h3s", omaha.calculate(("4h6s3dAhQh Ac7c5c2c Kh6h3h3s")));}
        @Test public void testOmaha13(){ Application.typeOfPoker = "omaha-holdem";assertEquals("Tc9d9h3h 6c5d4d2c", omaha.calculate(("4c3s9c2d6h 6c5d4d2c Tc9d9h3h")));}
        @Test public void testOmaha14(){ Application.typeOfPoker = "omaha-holdem";assertEquals("Ad8h7c4d AsTs8d2h", omaha.calculate(("AhTc9c4sQh Ad8h7c4d AsTs8d2h")));}
        @Test public void testOmaha15(){ Application.typeOfPoker = "omaha-holdem";assertEquals("Ad9c7s4d KcKhQsJh", omaha.calculate(("9sQd7c8c8s KcKhQsJh Ad9c7s4d")));}
        @Test public void testOmaha16(){ Application.typeOfPoker = "omaha-holdem";assertEquals("JcTh9h6s JsTs9s7h As7d5s2d", omaha.calculate(("Tc8sQs6d2s JcTh9h6s JsTs9s7h As7d5s2d")));}
        @Test public void testOmaha17(){ Application.typeOfPoker = "omaha-holdem";assertEquals("Ac7c4h3h AdAhQd6d", omaha.calculate(("3dJd8d8sAs Ac7c4h3h AdAhQd6d")));}
        @Test public void testOmaha18(){ Application.typeOfPoker = "omaha-holdem";assertEquals("Kh8d7s6h AhJh9h6d QdTdTs2h", omaha.calculate(("4hJdTh3s8c AhJh9h6d QdTdTs2h Kh8d7s6h")));}
        @Test public void testOmaha19(){ Application.typeOfPoker = "omaha-holdem";assertEquals("JhTh7s6s QdQh4d3d", omaha.calculate(("Qs2cKs8c6h JhTh7s6s QdQh4d3d")));}
        @Test public void testOmaha20(){ Application.typeOfPoker = "omaha-holdem";assertEquals("JdJs9d6s KdQd9c5c", omaha.calculate(("5dQs9h8s4c KdQd9c5c JdJs9d6s")));}
        @Test public void testOmaha21(){ Application.typeOfPoker = "omaha-holdem";assertEquals("AsQdQsJd Jh8s7d6h Ah8h6s4c", omaha.calculate(("KhQh4hAc3h AsQdQsJd Jh8s7d6h Ah8h6s4c")));}
        @Test public void testOmaha22(){ Application.typeOfPoker = "omaha-holdem";assertEquals("AhQdTcTh KdQcQs4d JhTs7c4c", omaha.calculate(("4sQhKh3sAc AhQdTcTh KdQcQs4d JhTs7c4c")));}
        @Test public void testOmaha23(){ Application.typeOfPoker = "omaha-holdem";assertEquals("Kc6c6d2c KhQhJh7c", omaha.calculate(("Th2sQcQd4s KhQhJh7c Kc6c6d2c")));}
        @Test public void testOmaha24(){ Application.typeOfPoker = "omaha-holdem";assertEquals("KhTd4c4h AcAdTh8c", omaha.calculate(("2hJcJh6s2d KhTd4c4h AcAdTh8c")));}
        @Test public void testOmaha25(){ Application.typeOfPoker = "omaha-holdem";assertEquals("Ts9s8s6d AsQsTh3h", omaha.calculate(("8c3sAdAh5s Ts9s8s6d AsQsTh3h")));}
        @Test public void testOmaha26(){ Application.typeOfPoker = "omaha-holdem";assertEquals("QdQsJh7h KcTs7s2c", omaha.calculate(("Jc9cKs4s3d QdQsJh7h KcTs7s2c")));}
        @Test public void testOmaha27(){ Application.typeOfPoker = "omaha-holdem";assertEquals("AcKh9h2c Kd5d5h3c", omaha.calculate(("KcJcKs3h5c AcKh9h2c Kd5d5h3c")));}
        @Test public void testOmaha28(){ Application.typeOfPoker = "omaha-holdem";assertEquals("KhQdQs4s Ac6h3c2d", omaha.calculate(("5d4dKs2s3d KhQdQs4s Ac6h3c2d")));}
        @Test public void testOmaha29(){ Application.typeOfPoker = "omaha-holdem";assertEquals("AsKhQhJh AcAh9c9h 6h4c3c2h", omaha.calculate(("6cJs3h5dTh AcAh9c9h AsKhQhJh 6h4c3c2h")));}
        @Test public void testOmaha30(){ Application.typeOfPoker = "omaha-holdem";assertEquals("AcAh6c4c AsKcKhJd", omaha.calculate(("2hKd8s5hKs AcAh6c4c AsKcKhJd")));}
        @Test public void testOmaha31(){ Application.typeOfPoker = "omaha-holdem";assertEquals("QhTs9d7h KhTcTd9s", omaha.calculate(("Jd3cTh9hAc QhTs9d7h KhTcTd9s")));}
        @Test public void testOmaha32(){ Application.typeOfPoker = "omaha-holdem";assertEquals("JcJs5d5s AdAs9c6c KcKsQh8h", omaha.calculate(("ThJdAh8c2c JcJs5d5s AdAs9c6c KcKsQh8h")));}
        @Test public void testOmaha33(){ Application.typeOfPoker = "omaha-holdem";assertEquals("8d7cTcJd 6h7d2cJc Qd3cKs4c Kh4hKc7h KdJs2hAh 5s5d7s4d TsQh9hQc", omaha.calculate(("5c6dAcAsQs TsQh9hQc 8d7cTcJd 5s5d7s4d Qd3cKs4c KdJs2hAh Kh4hKc7h 6h7d2cJc")));}
        @Test public void testOmaha34(){ Application.typeOfPoker = "omaha-holdem";assertEquals("9h7h2dTc 7cThKs5s 7sJdKcAs 8d9s5c4h 5hJh2s7d Qh8cTsJc 8s2h6s8h", omaha.calculate(("3d4s5dJsQd 8s2h6s8h 7cThKs5s 5hJh2s7d 8d9s5c4h 7sJdKcAs 9h7h2dTc Qh8cTsJc")));}
        @Test public void testOmaha35(){ Application.typeOfPoker = "omaha-holdem";assertEquals("Qc8dAd6c KsAsTcTs Js2dKd8c 7dQsAc5d Jh2h3c9c", omaha.calculate(("3d3s4d6hJc Js2dKd8c KsAsTcTs Jh2h3c9c Qc8dAd6c 7dQsAc5d")));}

        @Test public void testFiveCardDraw1(){ Application.typeOfPoker = "five-card-draw"; assertEquals("4c8h2h6c9c Ah9d6s2cKh Kd9sAs3cQs 7h4s4h8c9h Tc5h6dAc5c", fiveCardDraw.calculate(("7h4s4h8c9h Tc5h6dAc5c Kd9sAs3cQs Ah9d6s2cKh 4c8h2h6c9c")));}
        @Test public void testFiveCardDraw2(){ Application.typeOfPoker = "five-card-draw"; assertEquals("4s5hTsQh9h Qc8d7cTcJd 5s5d7s4dQd 7h6h7d2cJc 3cKs4cKdJs 2hAhKh4hKc As6d5cQsAc", fiveCardDraw.calculate(("4s5hTsQh9h Qc8d7cTcJd 5s5d7s4dQd 3cKs4cKdJs 2hAhKh4hKc 7h6h7d2cJc As6d5cQsAc")));}
        @Test public void testFiveCardDraw3(){ Application.typeOfPoker = "five-card-draw"; assertEquals("4c8h2h6c9c Ah9d6s2cKh Kd9sAs3cQs 7h4s4h8c9h Tc5h6dAc5c", fiveCardDraw.calculate(("7h4s4h8c9h Tc5h6dAc5c Kd9sAs3cQs Ah9d6s2cKh 4c8h2h6c9c")));}
        @Test public void testFiveCardDraw4(){ Application.typeOfPoker = "five-card-draw"; assertEquals("5s3s4c2h9d 4h6s8hJd5d 5c3cQdTd9s 8dKsTc6c2c 8c3d7h7dTs KhJs9c5h9h AhQhKcQc2d", fiveCardDraw.calculate(("5s3s4c2h9d 8dKsTc6c2c 4h6s8hJd5d 5c3cQdTd9s AhQhKcQc2d KhJs9c5h9h 8c3d7h7dTs")));}
    }
