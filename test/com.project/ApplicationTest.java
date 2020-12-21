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
    public void allTestCases() {
        Application.typeOfPoker = "texas-holdem";
        assertEquals("Ac4d=Ad4s 5d6d As9s KhKd", texas.calculate(("4cKs4h8s7s Ad4s Ac4d As9s KhKd 5d6d")));
        assertEquals("KdKs 9hJh", texas.calculate(("2h3h4h5d8d KdKs 9hJh ")));
        assertEquals("KcKs=QsQc", texas.calculate(("AsAcAhAdKd KcKs QsQc")));
        assertEquals("8s8h AhAs", texas.calculate(("AdAc8d8c7c AhAs 8s8h")));
        assertEquals("KcKs=KdQs", texas.calculate(("AsAcAhAdKh KdQs KcKs")));
        assertEquals("7cAc=Js5s", texas.calculate(("7s4d6c3h5h 7cAc Js5s")));
        assertEquals("7c8c 8s8h", texas.calculate(("TsJdQcThAh 7c8c 8s8h")));
        assertEquals("Jh9h As5d 7d8s", texas.calculate(("5s7h5hAh7s As5d 7d8s Jh9h")));
        assertEquals("7s7d=TcKs", texas.calculate(("JsJd8c8h8s 7s7d TcKs")));
        assertEquals("Ad9s Ah5d", texas.calculate(("3s7d3c5h7h Ah5d Ad9s")));
        assertEquals("Ad9s=Ah5d", texas.calculate(("3sTd3hKc2h Ah5d Ad9s")));
        assertEquals("AdQs AhKd", texas.calculate(("3s7d3hJc2h AhKd AdQs")));
        assertEquals("AdAc AhAs", texas.calculate(("ThJhKhJc2h AhAs AdAc")));
        assertEquals("3h3s AdQs", texas.calculate(("ThJdKh3c2h 3h3s AdQs")));
        assertEquals("3h3s AsQs", texas.calculate(("TsJs3d3cKs 3h3s AsQs")));
        assertEquals("8s9s 7sTs", texas.calculate(("2sJs3s3c2h 8s9s 7sTs")));
        assertEquals("KhJc KdQs", texas.calculate(("AdKs5cJhQd KdQs KhJc")));
        assertEquals("7h7c KcQc", texas.calculate(("8d8s9cTh9s KcQc 7h7c")));
        assertEquals("7h7c QdAc", texas.calculate(("6d8sJc9hTs QdAc 7h7c")));
        assertEquals("AdAc 7h7c", texas.calculate(("6d8sJc9hTs AdAc 7h7c")));
        assertEquals("Ad9d=As3s", texas.calculate(("Kc9sThKdTs As3s Ad9d")));
        assertEquals("AdQs Ah3h", texas.calculate(("ThJdKhJc2h Ah3h AdQs")));
        assertEquals("8s9s 6sTs", texas.calculate(("2sKs3sAsJs 8s9s 6sTs")));
        assertEquals("2s6s=3s7s", texas.calculate(("9sKs8sAsJs 2s6s 3s7s")));
        assertEquals("KhJc KdQs", texas.calculate(("8dKs5c3h9s KdQs KhJc")));
        assertEquals("AdAc KhTc", texas.calculate(("KdKsJcJhJs AdAc KhTc")));
        assertEquals("7h7c KdQc", texas.calculate(("7d8sJcTs9h KdQc 7h7c")));
        assertEquals("KhJc KdQs", texas.calculate(("2d5s5c9hTs KdQs KhJc")));
        assertEquals("4d5d=6s7c", texas.calculate(("6h3d5c7s4s 6s7c 4d5d")));
        assertEquals("3cKh KdQh", texas.calculate(("2h5c8sAsKc KdQh 3cKh")));
        assertEquals("7s3c 8h3d 9c7d AsKd 9h9s TcJd=Ts3s 4dQs", texas.calculate(("5d5h6hQdTd 7s3c Ts3s 9c7d 8h3d 9h9s AsKd 4dQs TcJd")));
        assertEquals("Ac4d=Ad4s 5d6d As9s KhKd", texas.calculate(("4cKs4h8s7s Ad4s Ac4d As9s KhKd 5d6d")));
        assertEquals("KdKs 9hJh", texas.calculate(("2h3h4h5d8d KdKs 9hJh")));
        assertEquals("7c8h Qc4h", texas.calculate(("JcTc9c8cAd Qc4h 7c8h")));
        assertEquals("8s8h AhAs", texas.calculate(("AdAc8d8c7c AhAs 8s8h")));
        assertEquals("9s8d JsTd", texas.calculate(("AdAcAhAs7c 9s8d JsTd")));
        assertEquals("TsTh AdAc", texas.calculate(("Ah4h2d7sTc TsTh AdAc")));
        assertEquals("Qh7s QcJh", texas.calculate(("Ah4hAsAc5d QcJh Qh7s")));
        assertEquals("3cJs Td9c", texas.calculate(("QcQhTs8s3h Td9c 3cJs")));
        assertEquals("Td9c TcJs", texas.calculate(("QcQhTs8s3h Td9c TcJs")));
        assertEquals("Js4d 2cQh", texas.calculate(("AhKs8s6d5c 2cQh Js4d")));
        assertEquals("7dJc KsQh", texas.calculate(("AsTd8d6c4h KsQh 7dJc")));
        assertEquals("JdTd AcAh 6h6d 2cJc", texas.calculate(("KdQd8c6c5c AcAh JdTd 6h6d 2cJc")));
        assertEquals("JdTd AcAh 6h6d 2cJc", texas.calculate(("KdQd8c6c5c AcAh JdTd 6h6d 2cJc")));
        assertEquals("9s5s 7c7d", texas.calculate(("5cAcAdAh5h 7c7d 9s5s")));
        assertEquals("9s4s 7c7d", texas.calculate(("5cAcAdAh5h 7c7d 9s4s")));
        assertEquals("5c4d TcQs", texas.calculate(("6c7c8c9cKd TcQs 5c4d")));
        assertEquals("5c4d=TcQs", texas.calculate(("5h6h7h8h9h TcQs 5c4d")));
        assertEquals("KhKd Ac2c", texas.calculate(("QdQsQhQc5d KhKd Ac2c")));
        assertEquals("Ac2c=KhAd", texas.calculate(("QdQsQhQc5d KhAd Ac2c")));
        assertEquals("2d3s 3d6s", texas.calculate(("AsKsTs7s5s 2d3s 3d6s")));
        assertEquals("ThJs TcQh", texas.calculate(("8s9cJd7h2s ThJs TcQh")));
        assertEquals("Kh9s TsKd", texas.calculate(("Ks9cTh2d6c TsKd Kh9s")));
        assertEquals("QhQd KhTc Ah3s", texas.calculate(("AdKd5s9c8c KhTc Ah3s QhQd")));
        assertEquals("4c4h Ac9d", texas.calculate(("5d5c6c6hKd 4c4h Ac9d")));
        assertEquals("4c4h=8c9d", texas.calculate(("5d5c6c6hKd 4c4h 8c9d")));
        assertEquals("6dKd=Ad5d", texas.calculate(("TsJsQsKsAs Ad5d 6dKd")));
        assertEquals("6s6d JsJd", texas.calculate(("8s9sTs7s2d 6s6d JsJd")));
        assertEquals("6s6d JsJd", texas.calculate(("8s9dTs7h2d 6s6d JsJd")));
        assertEquals("6s6h=JsJd", texas.calculate(("2s3d4s5h6d 6s6h JsJd")));
        assertEquals("As8h 6sJd", texas.calculate(("2s3d4s5h8d As8h 6sJd")));
        assertEquals("As8h 6sJd", texas.calculate(("2s3s4s5s8d As8h 6sJd")));
        assertEquals("8sJd Qh7h", texas.calculate(("8d8h4sQsQd Qh7h 8sJd")));
        assertEquals("Qh7h Qc9d", texas.calculate(("8d8h9sQsQd Qh7h Qc9d")));
        assertEquals("9c7h=Jc9d", texas.calculate(("8d8h8sQsQd 9c7h Jc9d")));
        assertEquals("2cJc Kh4h=Ks4c Kc7h KdJs 6h7d 2hAh", texas.calculate(("5c6dAcAsQs Ks4c KdJs 2hAh Kh4h Kc7h 6h7d 2cJc")));
        assertEquals("Jc6s Qs9h 3cKh KdQh", texas.calculate(("2h5c8sAsKc Qs9h KdQh 3cKh Jc6s")));
        assertEquals("9h7h 2dTc KcAs 7sJd TsJc Qh8c 5c4h", texas.calculate(("3d4s5dJsQd 5c4h 7sJd KcAs 9h7h 2dTc Qh8c TsJc")));

        Application.typeOfPoker = "omaha-holdem";
        assertEquals("2c2d3c3d 4c4d5c5d 6c6d7c7h", omaha.calculate(("7s7dKsKhQs 2c2d3c3d 4c4d5c5d 6c6d7c7h")));
        assertEquals("Qc8dAd6c KsAsTcTs Js2dKd8c 7dQsAc5d Jh2h3c9c", omaha.calculate(("3d3s4d6hJc Js2dKd8c KsAsTcTs Jh2h3c9c Qc8dAd6c 7dQsAc5d")));
        assertEquals("4d3h2hQh 4c8s9d5d", omaha.calculate(("QdTd3sJcTs 4d3h2hQh 4c8s9d5d")));
        assertEquals("AcAs5h2c KcQcJd7d", omaha.calculate(("KhQdQsKs5d KcQcJd7d AcAs5h2c")));
        assertEquals("KdKs7h5d AhJc5h4c", omaha.calculate(("4h7s4d2h5c KdKs7h5d AhJc5h4c")));
        assertEquals("Td9s8d4c AsJcJs3c", omaha.calculate(("4s5cQc3hQh AsJcJs3c Td9s8d4c")));
        assertEquals("8h7d5s2d AcKhTs8c", omaha.calculate(("6c4s7c9c9d 8h7d5s2d AcKhTs8c")));
        assertEquals("KdTdTs2s AsKcKs9d", omaha.calculate(("9c8cKh3sQs AsKcKs9d KdTdTs2s")));
        assertEquals("8h7d5s2d AcKhTs8c", omaha.calculate(("6c4s7c9c9d 8h7d5s2d AcKhTs8c")));
        assertEquals("AcKhTc2d AhAsJs6h", omaha.calculate(("7h8dKcTh9h AhAsJs6h AcKhTc2d")));
        assertEquals("Ac7c5c2c Kh6h3h3s", omaha.calculate(("4h6s3dAhQh Ac7c5c2c Kh6h3h3s")));
        assertEquals("Tc9d9h3h 6c5d4d2c", omaha.calculate(("4c3s9c2d6h 6c5d4d2c Tc9d9h3h")));
        assertEquals("Ad8h7c4d AsTs8d2h", omaha.calculate(("AhTc9c4sQh Ad8h7c4d AsTs8d2h")));
        assertEquals("Ad9c7s4d KcKhQsJh", omaha.calculate(("9sQd7c8c8s KcKhQsJh Ad9c7s4d")));
        assertEquals("JcTh9h6s JsTs9s7h As7d5s2d", omaha.calculate(("Tc8sQs6d2s JcTh9h6s JsTs9s7h As7d5s2d")));
        assertEquals("Ac7c4h3h AdAhQd6d", omaha.calculate(("3dJd8d8sAs Ac7c4h3h AdAhQd6d")));
        assertEquals("Kh8d7s6h AhJh9h6d QdTdTs2h", omaha.calculate(("4hJdTh3s8c AhJh9h6d QdTdTs2h Kh8d7s6h")));
        assertEquals("JhTh7s6s QdQh4d3d", omaha.calculate(("Qs2cKs8c6h JhTh7s6s QdQh4d3d")));
        assertEquals("JdJs9d6s KdQd9c5c", omaha.calculate(("5dQs9h8s4c KdQd9c5c JdJs9d6s")));
        assertEquals("AsQdQsJd Jh8s7d6h Ah8h6s4c", omaha.calculate(("KhQh4hAc3h AsQdQsJd Jh8s7d6h Ah8h6s4c")));
        assertEquals("AhQdTcTh KdQcQs4d JhTs7c4c", omaha.calculate(("4sQhKh3sAc AhQdTcTh KdQcQs4d JhTs7c4c")));
        assertEquals("Kc6c6d2c KhQhJh7c", omaha.calculate(("Th2sQcQd4s KhQhJh7c Kc6c6d2c")));
        assertEquals("KhTd4c4h AcAdTh8c", omaha.calculate(("2hJcJh6s2d KhTd4c4h AcAdTh8c")));
        assertEquals("Ts9s8s6d AsQsTh3h", omaha.calculate(("8c3sAdAh5s Ts9s8s6d AsQsTh3h")));
        assertEquals("QdQsJh7h KcTs7s2c", omaha.calculate(("Jc9cKs4s3d QdQsJh7h KcTs7s2c")));
        assertEquals("AcKh9h2c Kd5d5h3c", omaha.calculate(("KcJcKs3h5c AcKh9h2c Kd5d5h3c")));
        assertEquals("KhQdQs4s Ac6h3c2d", omaha.calculate(("5d4dKs2s3d KhQdQs4s Ac6h3c2d")));
        assertEquals("AsKhQhJh AcAh9c9h 6h4c3c2h", omaha.calculate(("6cJs3h5dTh AcAh9c9h AsKhQhJh 6h4c3c2h")));
        assertEquals("AcAh6c4c AsKcKhJd", omaha.calculate(("2hKd8s5hKs AcAh6c4c AsKcKhJd")));
        assertEquals("QhTs9d7h KhTcTd9s", omaha.calculate(("Jd3cTh9hAc QhTs9d7h KhTcTd9s")));
        assertEquals("JcJs5d5s AdAs9c6c KcKsQh8h", omaha.calculate(("ThJdAh8c2c JcJs5d5s AdAs9c6c KcKsQh8h")));
        assertEquals("8d7cTcJd 6h7d2cJc Qd3cKs4c Kh4hKc7h KdJs2hAh 5s5d7s4d TsQh9hQc", omaha.calculate(("5c6dAcAsQs TsQh9hQc 8d7cTcJd 5s5d7s4d Qd3cKs4c KdJs2hAh Kh4hKc7h 6h7d2cJc")));
        assertEquals("9h7h2dTc 7cThKs5s 7sJdKcAs 8d9s5c4h 5hJh2s7d Qh8cTsJc 8s2h6s8h", omaha.calculate(("3d4s5dJsQd 8s2h6s8h 7cThKs5s 5hJh2s7d 8d9s5c4h 7sJdKcAs 9h7h2dTc Qh8cTsJc")));
        assertEquals("Qc8dAd6c KsAsTcTs Js2dKd8c 7dQsAc5d Jh2h3c9c", omaha.calculate(("3d3s4d6hJc Js2dKd8c KsAsTcTs Jh2h3c9c Qc8dAd6c 7dQsAc5d")));

        Application.typeOfPoker = "five-card-draw";
        assertEquals("4c8h2h6c9c Ah9d6s2cKh Kd9sAs3cQs 7h4s4h8c9h Tc5h6dAc5c", fiveCardDraw.calculate(("7h4s4h8c9h Tc5h6dAc5c Kd9sAs3cQs Ah9d6s2cKh 4c8h2h6c9c")));
        assertEquals("4s5hTsQh9h Qc8d7cTcJd 5s5d7s4dQd 7h6h7d2cJc 3cKs4cKdJs 2hAhKh4hKc As6d5cQsAc", fiveCardDraw.calculate(("4s5hTsQh9h Qc8d7cTcJd 5s5d7s4dQd 3cKs4cKdJs 2hAhKh4hKc 7h6h7d2cJc As6d5cQsAc")));
        assertEquals("4c8h2h6c9c Ah9d6s2cKh Kd9sAs3cQs 7h4s4h8c9h Tc5h6dAc5c", fiveCardDraw.calculate(("7h4s4h8c9h Tc5h6dAc5c Kd9sAs3cQs Ah9d6s2cKh 4c8h2h6c9c")));
        assertEquals("5s3s4c2h9d 4h6s8hJd5d 5c3cQdTd9s 8dKsTc6c2c 8c3d7h7dTs KhJs9c5h9h AhQhKcQc2d", fiveCardDraw.calculate(("5s3s4c2h9d 8dKsTc6c2c 4h6s8hJd5d 5c3cQdTd9s AhQhKcQc2d KhJs9c5h9h 8c3d7h7dTs")));
    }
}