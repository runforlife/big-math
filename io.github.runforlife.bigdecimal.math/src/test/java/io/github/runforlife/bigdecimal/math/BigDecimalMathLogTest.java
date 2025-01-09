package io.github.runforlife.bigdecimal.math;

import io.github.runforlife.bigdecimal.math.stream.BigDecimalStream;
import io.github.runforlife.bigdecimal.math.util.AbstractBigDecimalTest;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.Assert.assertEquals;

public class BigDecimalMathLogTest extends AbstractBigDecimalTest {
    @Test
    public void testLogRange10() {
        double step = getRangeStep(0.1);
        BigDecimalStream.range(step, 10.0, step, MC).forEach(x -> {
            System.out.println("Testing log(" + x + ")");
            assertBigDecimal("log(" + x + ")",
                    toCheck(Math.log(x.doubleValue())),
                    BigDecimalMath.log(x, MC),
                    MC_CHECK_DOUBLE);

            BigDecimal finalX = x;
            assertPrecisionCalculation(
                    mathContext -> BigDecimalMath.log(finalX, mathContext),
                    10, AUTO_TEST_MAX_PRECISION);
        });
    }

    @Test
    public void testLogRange100() {
        double step = getRangeStep(1.0);
        BigDecimalStream.range(step, 100.0, step, MC).forEach(x -> {
            System.out.println("Testing log(" + x + ")");
            assertBigDecimal("log(" + x + ")",
                    toCheck(Math.log(x.doubleValue())),
                    BigDecimalMath.log(x, MC),
                    MC_CHECK_DOUBLE);

            BigDecimal finalX = x;
            assertPrecisionCalculation(
                    mathContext -> BigDecimalMath.log(finalX, mathContext),
                    10, AUTO_TEST_MAX_PRECISION);
        });
    }

    @Test
    public void testLogHighAccuracy1() {
        // Result from wolframalpha.com: ln(0.1)
        BigDecimal expected = BigDecimalMath.toBigDecimal("-2.30258509299404568401799145468436420760110148862877297603332790096757260967735248023599720508959829834196778404228624863340952546508280675666628736909878168948290720832555468084379989482623319852839350530896537773262884616336622228769821988674654366747440424327436515504893431493939147961940440022210510171417480036880840126470806855677432162283552201148046637156591213734507478569476834636167921018064450706480002775026849167465505868569356734206705811364292245544057589257242082413146956890167589402567763113569192920333765871416602301057030896345720754403708474699401682692828084811842893148485249486448719278096762712757753970276686059524967166741834857044225071979650047149510504922147765676369386629769795221107182645497347726624257094293225827985025855097852653832076067263171643095059950878075237103331011978575473315414218084275438635917781170543098274823850456480190956102992918243182375253577097505395651876975103749708886921802051893395072385392051446341972652872869651108625714921988499787488737713456862091670584980782805975119385444500997813114691593466624107184669231010759843831919129223079250374729865092900988039194170265441681633572755570315159611356484654619089704281976336583698371632898217440736600916217785054177927636773114504178213766011101073104239783252189489881759792179866639431952393685591644711824675324563091252877833096360426298215304087456092776072664135478757661626292656829870495795491395491804920906943858079003276301794150311786686209240853794986126493347935487173745167580953708828106745244010589244497647968607512027572418187498939597164310551884819528833074669931781463493000032120032776565413047262188397059679445794346834321839530441484480370130575367426215367557981477045803141363779323629156012818533649846694226146520645994207291711937060244492");
        assertPrecisionCalculation(
                expected,
                mathContext -> BigDecimalMath.log(BD("0.1"), mathContext),
                10);
    }

    @Test
    public void testLogHighAccuracy2() {
        // Result from wolframalpha.com: ln(1.1)
        BigDecimal expected = BigDecimalMath.toBigDecimal("0.0953101798043248600439521232807650922206053653086441991852398081630010142358842328390575029130364930727479418458517498888460436935129806386890150217023263755687346983551204157456607731117050481406611584967219092627683199972666804124629171163211396201386277872575289851216418802049468841988934550053918259553296705084248072320206243393647990631942365020716424972582488628309770740635849277971589257686851592941134955982468458204470563781108676951416362518738052421687452698243540081779470585025890580291528650263570516836272082869034439007178525831485094480503205465208833580782304569935437696233763597527612962802332419887793490159262767738202097437296124304231269978317763387834500850947983607954894765663306829441000443449252110585597386446423305000249520642003351749383035733163887183863658864095987980592896922224719866617664086469438599082172014984648661016553883267832731905893594398418365160836037053676940083743785539126726302367554039807719021730407981203469520199824994506211545156995496539456365581027383589659382402015390419603824664083368873307873019384357785045824504691072378535575392646883979065139246126662251603763318447377681731632334250380687464278805888614468777887659631017437620270326399552535490068490417697909725326896790239468286121676873104226385183016443903673794887669845552057786043820598162664741719835262749471347084606772426040314789592161567246837020619602671610506695926435445325463039957620861253293473952704732964930764736250291219054949541518603372096218858644670199237818738241646938837142992083372427353696766016209216197009652464144415416340684821107427035544058078681627922043963452271529803892396332155037590445683916173953295983049207965617834301297873495901595044766960173144576650851894013006899406665176310040752323677741807454239794575425116685728529323731335086049670268306");
        assertPrecisionCalculation(
                expected,
                mathContext -> BigDecimalMath.log(BD("1.1"), mathContext),
                10);
    }

    @Test
    public void testLogHighAccuracy3() {
        // Result from wolframalpha.com: ln(12345.6)
        BigDecimal expected = BigDecimalMath.toBigDecimal("9.42105500327135525114521501453525399237436111276300326386323534432727151942992511520562558738175320737219392933678106934681377640298797158131139323906361961480381516008415766949640011144295651380957422777114172279167654006534622812747920122075143832000303491928864417567534602811492095685408856581074035803357797631847469251006466446952382984400769172787795491275890878474305023861509824367243299385769279771744041937866552134975148449991501344008449686333627176197439283560717007769286520651804657135365525410547797134491863813264296599988480767570621877413992243488449252058389112464675521921368744908030643106093708139694498213865760209374231089223703469389057990578641477811580679006647361045368883126313166757159295044784734054746026667561208850147352459931288221690064827656007945926558137817955314752299200021125335319543610643148781413031739368946686197126231424703883123190210238015791369611214420726133482521541649129324232190740641049135517129893844376556993789191631768552752257796461172834352906322971133196717292014063557464657868471260257837864581817895933554699436597231519928906186824100551929174973211768975723220457184410041128885431823059460270296159512608527194960997843854276107619358871611335110158160499192067423059751567986373407423489599586293284362977309927604782683386482396609096117347165767675657470578510018397575185923185572052807175571518796143517238193372303027925460053807069802388627060672427272087223286476333683468229892546440731981947511457788744089944064466689422654892614083398427300212135529866471079161390374604296893598724751037581346990096479637907462110313260901383748633868418336284029147686046156013978973990920093756659785588328734878986910751799701679853456356654554727303139653731884939067754728654663370026652097310980166441905496504187282659704649813546716585697691");
        assertPrecisionCalculation(
                expected,
                mathContext -> BigDecimalMath.log(BD("12345.6"), mathContext),
                10);
    }

    @Test
    public void testLogNotorious1() {
        // Result from wolframalpha.com: ln(3.627)
        // result contains digit sequence 249999790 which is tricky
        BigDecimal expected = BD("1.28840586030076531271916787589963460174688352499997906354516854751071684132712190465267938913524540189227183498685955203091012976295191938570887410037177795976156712449887694786077349630415919676796628382920641191635039097198525638716788242413712812154035694161623839896238526801424419472197899141291552341986057193552767761847325665588799624460996389716450246797586099819246857022106263044473561032621692801928684892761931286774706996443604259279886700716");
        assertPrecisionCalculation(
                expected,
                mathContext -> BigDecimalMath.log(BD("3.627"), mathContext),
                10);
    }

    @Test
    public void testLogSmall() {
        // Result from wolframalpha.com: log(1e-399)
        BigDecimal expected = BD("-918.731452104624227923178590419061318832839493962880417437");
        assertEquals(expected.round(MC), BigDecimalMath.log(BD("1E-399"), MC));
    }

    @Test
    public void testLogHuge() {
        // Result from wolframalpha.com: log(1e399)
        BigDecimal expected = BD("918.7314521046242279231785904190613188328394939628804174372");
        assertEquals(expected.round(MC), BigDecimalMath.log(BD("1E399"), MC));
    }

    @Test
    public void testLogRandom() {
        assertRandomCalculation(
                adaptCount(100),
                "log",
                random -> random.nextDouble() * 100 + 0.00001,
                Math::log,
                (x, mathContext) -> BigDecimalMath.log(x, mathContext));
    }

    @Test(expected = ArithmeticException.class)
    public void testLogNegative() {
        BigDecimalMath.log(BigDecimal.valueOf(-1), MC);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testLogUnlimitedFail() {
        BigDecimalMath.log(BigDecimal.valueOf(2), MathContext.UNLIMITED);
    }
}