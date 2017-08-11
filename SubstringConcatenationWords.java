import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatenationWords {  //第30题
    public List<Integer> findSubstring(String s, String[] words) { // 355ms
        List<Integer> ans = new ArrayList<>();

        int wordnum = words[0].length();
        int wordlen = words.length;
        int col = wordlen * wordnum;

        for(int i = 0; i <= s.length() - col; i++) {
            if(isMatch(s, i, words)) {
                ans.add(i);
                // System.out.println(s.substring(i, i+col));
           }
//          else {
//                System.out.println("    false");
//            }
        }
        return ans;
    }
    private boolean isMatch(String s, int begin, String[] words) {
        int[] book = new int[words.length];  // 标记每个 word 是否已经匹配了
        int wordsnum = words[0].length();

        for (int i = 0; i < words.length; i++) {
            String temp = s.substring(begin+i*wordsnum, begin+(i+1)*wordsnum);
            // System.out.println(temp);
            for(int j = 0; j < words.length; j++) {
                if(book[j] == 0 && temp.equals(words[j])) {
                    book[j] = 1;
                    // System.out.println("   "+words[j]);
                    break;
                }
            }
        }
        for(int i = 0; i < words.length; i++) {
            if(book[i] == 0) {
                return false;
            }
        }
        return true;
    }


    public List<Integer> findSubstring_1(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int n = s.length(), m = words.length, k;
        if (n == 0 || m == 0 || (k = words[0].length()) == 0)
            return res;

        HashMap<String, Integer> wDict = new HashMap<String, Integer>();

        for (String word : words) {
            if (wDict.containsKey(word))
                wDict.put(word, wDict.get(word) + 1);
            else
                wDict.put(word, 1);
        }

        int i, j, start, x, wordsLen = m * k;
        HashMap<String, Integer> curDict = new HashMap<String, Integer>();
        String test, temp;
        for (i = 0; i < k; i++) {
            curDict.clear();
            start = i;
            if (start + wordsLen > n)
                return res;
            for (j = i; j + k <= n; j += k) {
                test = s.substring(j, j + k);

                if (wDict.containsKey(test)) {
                    if (!curDict.containsKey(test)) {
                        curDict.put(test, 1);

                        start = checkFound(res, start, wordsLen, j, k, curDict, s);
                        continue;
                    }

                    // curDict.containsKey(test)
                    x = curDict.get(test);
                    if (x < wDict.get(test)) {
                        curDict.put(test, x + 1);

                        start = checkFound(res, start, wordsLen, j, k, curDict, s);
                        continue;
                    }

                    // curDict.get(test)==wDict.get(test), slide start to
                    // the next word of the first same word as test
                    while (!(temp = s.substring(start, start + k)).equals(test)) {
                        decreaseCount(curDict, temp);
                        start += k;
                    }
                    start += k;
                    if (start + wordsLen > n)
                        break;
                    continue;
                }

                // totally failed up to index j+k, slide start and reset all
                start = j + k;
                if (start + wordsLen > n)
                    break;
                curDict.clear();
            }
        }
        return res;
    }
    public int checkFound(List<Integer> res, int start, int wordsLen, int j, int k, HashMap<String, Integer> curDict, String s) {
        if (start + wordsLen == j + k) {
            res.add(start);
            // slide start to the next word
            decreaseCount(curDict, s.substring(start, start + k));
            return start + k;
        }
        return start;
    }

    public void decreaseCount(HashMap<String, Integer> curDict, String key) {
        // remove key if curDict.get(key)==1, otherwise decrease it by 1
        int x = curDict.get(key);
        if (x == 1)
            curDict.remove(key);
        else
            curDict.put(key, x - 1);
    }


    public static void main(String args[]) {
        SubstringConcatenationWords test = new SubstringConcatenationWords();

        String s = "xjpguhvytyjcknhjqkwelhjqbdgtwxgvgxbdeydxwozidiutuqafxjxaodtkdbfjyiocgtbfhcplmjggbgoarlcgpxssyadyiuapndwxhlitvoayvqzobbuqzpkzpqyzkaqzgmwnyghvvjtszuiawdtxufylvwkhzbhfpfsnmbkjkedlylowqjvkquxmsivrlewakrqysahfgmqhxgfqpbcgxaupkrhvwfviwngrqpwybohaxnsoqvwpxqehkncgvzqtpwkflidoznqwcjksehjdzpkjdmranhtcfejsopgncxjeguymbhpcwbmbpfbcnvhsbqnpftdjsonainoludqtgcwvjyywvhryxepfzuqsjgstthhqmxltbhokfojcvcavgqchmszvyupudykrvvmwedikrroptrmbjojvgkrheibjgnbdknboqjakbpbwgnyrbhmjtfqantjvgmaqcbhulhgowhkeukvxrkhnpznfvwcdldwnedjpkqfjxqnualruvahmcwrxuuafxwubzetmwyvtqkntvhnshwhjsyimujuthoxjuqvqqqmhazayipsqnzbfaktuvpocennadirvadcdeedpvvfixipxujtpajugwhhbsaxsfbvliaadwhmvqbsmmnenxavvhcxbcwwjxtvfuvlqdxlvafhpsnernznxemygiuqfonniiyanxnkzuuoohugvwvsajsirnyydnnnwnplkcwkyqamxvuurrmrafztuauzphmlvdzhfvrflurkpmfidtbgycbuevtufhhakgjrdbwqvqbmciwhbxpcbrwgmscrbjtmsffvgemdupryxphaoxcpobxcvbwwnrkfwscewqjsfcqerzffwjxmmwrhynelgosfiujenvwsxozpogwmrtbeqslqhrbnitsqpevcztxykynaemmvhnbzhnpogqeolyfdccfdxecjcrjidyelnhmvuclduprioylscswaxylbpvkvvqikxuhuytxtkqbapottgrvfphjgetdzjljigrcembzwsczjqsczlygcfpijkmktzvehmgoaknzcqylisnjdlqfshpbsdnndjrkxayykoxogxzqpoascsxubmytsljvuahucisowrccobudsuxuouoqimlaauxwxhqbpkqldsptwjyogviurymclyenueltlcvaollufcnbnmptjzqbycflcjyxnjsynnaealygpljdzzyjyomyrtjvchustnsgctkdgklwwubxvziwouuhpecslxmgmepoxbremcckzdhucqqqmlzcpcwcbilnmabkbtqpxszwvhtzzjslwrnntlsutdjgflsigkyfcxezexydiqrfigudsmalrjtwunfcxdibcmajjbotrfybmtfghftzqpxlcepcjxdmlgvwhjqarqcdlhltoeuettryyhahgfvsnqqucgxtzzykijfwpbcjvujvdjelqadeswawcxpdwpoeyvcqxfzubipetvpjxvpqtqmxpebotpuumxkjelffvwlosczpzrhsjwqycrmvihrugbgkolrjiezcgbtisbadzsbblqytzsqfvyrklitvmvxuyrcqufvvzwyloygnqwsmwjwitrdhobcmugcqnzlnwlykjeaadsmzekhxdlhsojekrjafinseysrjyrjblxbrjkrnvyflhjvasxfbkzhkraustdtfdwymhpzengqwqnxklelvetixvcpphjwkhuzokavxhlwzatjlxxjdqrbnvsccdypltqzdswcbhyaktmxrjgwbzxowqrzvpqgkiipaescoscymovfxebyfbpctgdoxvxidfxdjrfzmkxaavhabiyilpkevpvvksfpzetiwakkkjklgrlhblqnbctyuqtgkawjfrubrenenxpuqcdrptgsyctusmadnyospivhminahewxgzoxvxqtzjntxpymongdvdmknzkudirlhijchbxgkmbjcawsnevkikuvjgspolcyvlacmakymmiqmgibkensqiqbqiqfttdpgfrvfevsqdkelthwzuqpegqvqjakefbmkuhsyfmokwswpbsqwkfatyvjjxvncwzprjhpoteypywhcqxybfaufyfovbbaxcponygdrkeikarmrrmuwnqblvpiwsiuwzkkxqnqctbpusdnlqhhfxkssbapvllskvekmtcqndfhyjujbdtgafauhclenwwaucmiwoyjugqupmfspaarganpcztqxssruebqucbqirkzfsrwsrnardpvclnzfftblusgyvwgnjfudyrvpgwijngnatnfbihmebudwtjlerihrbchjartqzistxyufhikkdpiwauarejjfnsooljglsygpyaxhijrnyalywnsawdfkxtaidgvxgbmhdloougbsipteclezqljnejvjrtgzuvgygvoddrxlgqrjdxititgoeeavxiwrfdroahrdzoqfhhokgygormevsespnpjsscgukzxjopoxyfjedpuxeyswfnoucxmwbvqlwpwmgljestkviesoennjabfeauabpsnljjapwjvochmnngbrvodxribredttvihgthxsssivbwkodniaelyvvzpadkvasejnngfgbqdcmprpczqgmoejptlsdjvxpekdmslniqqufjmhieqwuufjntescbpthbyttjhdbzaiiosssioocvzrqdjugaonbmhxyqczpcixqarkkfaocaftfqnmsbbtqisoyvppxzoqbfclmdzpdgkiyxwqbymtiehjzyyzynrzutnhymwbvimvhkmiiadtekcgjafjpyikrvtqkrthzhcgsqrcquvxhxdsakbrkldbjwttnpcowgvqzotriqorotjqfmhpylthhocxdelcmiulwpdhgtywpkmuwvmugfbqtfpzlcdylxjhnoovkprzzdtvafqjmtbizqhmsmkdlwnykdtusmvrrpnswfbjacrbuaommysxwhyjktdfgzwzqlrmssxtwowqqkfclxchgcqqvwvdxudnhwbarzvnpregclknkowqqniojgtgayvhvyjozebpwhxasjncajuqydghjcplakuxlelkipbgwygrkvvkfqcdvlnenerpplpapcmatogqmnjyiekpwpvrakxpoqgfcxhtcutvicnwrwvbdhtbwovyaupolyunxdizxcvfgiezhbamitnhjkhjfxaqxwfuznuzppgxzkwilxuuskdewkpbhprenwbpkvobmubnfxwqwsmrepvbakejcwqpuregmukaplnuklmjgzamqxpqjualsqdmhjvvefxtskpeybngcpstmilweljwdoimyfhcmgxermlrpyxuqrnebycfmmbpamcyrlceszkllvedwbxmumqwktbyhdojrskidmoxmbizymeupbimnbiawlydoomfgyqmlgjzhuygifcagnmwowykhypyndfvcvhpetolpotztybclpyblwlvuctjhyflwoaajonydhawfbysrytewgztiucrvhdrydthsgixpkvwlwoeujlrpmkzhorcywvwzoftwnsoxoklkbrekcxcrjdyywcwszsupxnlngbmwmxgprmbvkdmthmrdqnyphsehhsuptilhiryzeauqdhjmtdsmqqbakihtcdjxluhtofsufpklwvxryrdrjhrtpyntdyqouxkideeitotrmtlkkqbuxsposchvaamxxyfccknyairmbczovaiuvzjneslguzdsxjwbvjzxsrmvvljqntlitwyxqldlkjfjsbkpnmohfaecnqtblgleelduwjhismtmqgdfurozusbhkwkweyckjihitosldozvuccovqppksxvrjtxhvitdrbwfvjkjkhdmjtkbizodyluietpzbifslbahnmqxuwmfpwjaxzdwkzeqstrweworaqypfrmznagewreuqjqaiwsdrkzvgpnignxnemotmuylmcheozhyvzbmjaksqzcyoclvozocvmnjrwofvvdswhhghtazucziekdulsxjgkszjieefkxcrekaxkatozbtmhnzbmihzdhinnmtzlxsrjtqtvjjwleksukvgucfzlnpbcianhthqoxllhuhuzsotejbanhazwpcyzcoixvanulydhgxganbeydgmminizphatxitsigmvfqdnplnfptdszrgieohvxirwskodqdyxvdkmpzresxyuoeevunsuxjqqthvkmthhxuvotnsoksiayovsboobzfttoofahmhggcucroqdgaeeqbzrppupunkkbpkldtrkymopcgvjgzpwaopsekjaxtlzixkltdxrrliurddzesxfjnzpzipwbcxlcjwvpwmghwabafcgyanjnmymupkxukiwvhtkdhrmdrnfxsmxszihogtixfirpsplzixcrorvigcfyqeqqmxeusoraylprccsnaveqobyueftullmxjstdjndhavacztpzqusevqybwtwhfihodctmpxvpswurpjthfllddlezfcjknsaquvcmsxdmvzemjztqkgtpsarzcalpunhqiledlipgjttsuolgvewpenohnbyjogzyrebeorlxmgshudnpjjgowwxlxxunfwmzapdqgonvuhcrkriubpkzljnlghymdmlfcqvkflfbsjsfbdbculdfwqscatqffdljuiubvbcqlxvmcwqwjvbhmwjmpcrufegbpackdhaoexcgvucgqfncbzqsbjniotkfvmpytspzprflmjrerhgugynhhapxvzcsosqhmhjbzqonaittpznvzaegctezvgrjaksorbsssghuqanhbaeadihfenfzvykwiekcgcualeubejlglpioyrwceddabnymrioznkbaoxdtgobsejicbeghhjhjyfvrqltfvufksifyxgsdrbhufncnyjywrvphgimddtnxbsxayqdsrkmyxonxantrilaqtouyhjvicvlclouebjeaxsyxftqqeqgaecynmwyqrjuexpiyymbxgzxmsnexgkxmpxabvytmhnsgeahepicxhbjbonywaxjrxlusjnhsazyfchlrpnqyqaahpadryoivzepkrwcuwdbykmrachasjazbbfsbtdwvhnfbkivgnwgxkxzmeahqagrbnlchqacaqjbatyigwoggnfvtfcjikclyoqheslgiuhiohswdickvihrpjaxtflttbaztlgcgpmwxhsapvmnfteueguylfrgiugbfmflduhadcdsxphellypuupfbjojduniiuwlqfothrmggvkthljdfakjjysoshzcevquceokvcqdxbxgoijtkucwuxknglrkghfjlvviznowqnfexqyhkcdfbquibnskvzviwstvfhuwubatraaedglgwfozujlpkgahategcacybcrtftxiziqxpfxjqibcrdlryqzasbaugrplmmvmwljnsgwkrznkcydaqdcjgcfmvuziguweifrcopnhpcrtcuwtzyegdjsadsklogryoibczqjquckwygrygxeliymlswyhfphtxkxzaipwmzvkhoiomobunnifmgorwwmvgjujtmhflcpvraldomzbahjmqzfovrjecgpvuwafzrcqrnvicwlceuqwuxkrqvxsdmpxjrfkihccxzmzvxdbuvxqshhkdhcgttgeklousqyrpkqnitocqoskvbuaiwjeppibcxwupumhfeupakrqylbwovyxujblalncilxaflhmrdbrpuiqhlmwgmvawyowjbzumyutldicilwxggnprblzoicmgqkqrjkfjgywjgbrsxoaderwffvvnxhunsmedwjpcklnqogklwmqaemijidyfnsvfezkclzgvntnbbypymfysugdemcjzuggbgqftqmofhbgjbvhqdhixqmbcomdktjnbzturhkwonfxpagffqpegdfitulgpwtsvoopvylklqjctsjaizfoemyyglexhxpeodtjdhtpzftuxdvfeavimtgvemslmkranljtsfkrkdmjghomjjxvedqislvevmekzndtsnlerznzidorolosqhciszmnoszngdhasuflvundybwommhetlpnlbczucochvczrjlmgyrgbnuncdtvpilamnbippkwnoyeajrijiokyizaosxddifpwiznxlmkbkpdvileqzqqkpqyjodoyifuseippuctgtwbbihthxktmarxqwmpgrjyytonpsgvldymnffwepqssjqigexovjntedjwvrtgwssjzzgepywhjorpsreoctjgwucrmyxksrurqcxhcuoliidbzhrbccjyxoplmovefrxxvvfxpvjzdmcevvfxyrvxfmkrcfxjzugurnsijdiormtmialirihyurryyohxlnucbmlmrvaihvwpyhzrrgqnxhlwysvjhplkdywutzebwaswjsoaygnwnyunqpwahkkkijhcilfgmxdvptwqzlmokicczycgkprtyyxijcoxbtvrmthlevcodetcexlpmckkcjunljlmegfrboeflgwqmpvrmgibiulmdgzqrmcvukmvatbmzxemozfafndpjpdmxdcqrglmsajttkhujniznncucfklunxtsbjkixyczhvuueofsxfhmhbpmnchdccxdmhnlhqkpneluuqotvvgcyxpmzyrdaojo";
        String[] words = {"twjyogviurymclyenueltlcvao","tmilweljwdoimyfhcmgxermlrp","ikuvjgspolcyvlacmakymmiqmg","agrbnlchqacaqjbatyigwoggnf","mbzwsczjqsczlygcfpijkmktzv","vljqntlitwyxqldlkjfjsbkpnm","beqslqhrbnitsqpevcztxykyna","usqyrpkqnitocqoskvbuaiwjep","ibkensqiqbqiqfttdpgfrvfevs","wszsupxnlngbmwmxgprmbvkdmt","fpzetiwakkkjklgrlhblqnbcty","sxdmvzemjztqkgtpsarzcalpun","wceddabnymrioznkbaoxdtgobs","hpecslxmgmepoxbremcckzdhuc","ztuauzphmlvdzhfvrflurkpmfi","ptrmbjojvgkrheibjgnbdknboq","vgjujtmhflcpvraldomzbahjmq","ygormevsespnpjsscgukzxjopo","qdkelthwzuqpegqvqjakefbmku","hsazyfchlrpnqyqaahpadryoiv","ickvihrpjaxtflttbaztlgcgpm","hnshwhjsyimujuthoxjuqvqqqm","ejicbeghhjhjyfvrqltfvufksi","hustnsgctkdgklwwubxvziwouu","jrfzmkxaavhabiyilpkevpvvks","reuqjqaiwsdrkzvgpnignxnemo","wyloygnqwsmwjwitrdhobcmugc","fvwlosczpzrhsjwqycrmvihrug","ehmgoaknzcqylisnjdlqfshpbs","irvadcdeedpvvfixipxujtpaju","mcwrxuuafxwubzetmwyvtqkntv","lcjwvpwmghwabafcgyanjnmymu","hdloougbsipteclezqljnejvjr","hmrdqnyphsehhsuptilhiryzea","wunfcxdibcmajjbotrfybmtfgh","aeeqbzrppupunkkbpkldtrkymo","rbnvsccdypltqzdswcbhyaktmx","jqqthvkmthhxuvotnsoksiayov","uqtgkawjfrubrenenxpuqcdrpt","mvmwljnsgwkrznkcydaqdcjgcf","wcdldwnedjpkqfjxqnualruvah","bamitnhjkhjfxaqxwfuznuzppg","moxmbizymeupbimnbiawlydoom","xyfjedpuxeyswfnoucxmwbvqlw","aftfqnmsbbtqisoyvppxzoqbfc","zepkrwcuwdbykmrachasjazbbf","akjjysoshzcevquceokvcqdxbx","pcgvjgzpwaopsekjaxtlzixklt","zucziekdulsxjgkszjieefkxcr","jrnyalywnsawdfkxtaidgvxgbm","xpkvwlwoeujlrpmkzhorcywvwz","qzotriqorotjqfmhpylthhocxd","wymhpzengqwqnxklelvetixvcp","ceuqwuxkrqvxsdmpxjrfkihccx","iwstvfhuwubatraaedglgwfozu","ohfaecnqtblgleelduwjhismtm","ekaxkatozbtmhnzbmihzdhinnm","uvxhxdsakbrkldbjwttnpcowgv","vafhpsnernznxemygiuqfonnii","sbtdwvhnfbkivgnwgxkxzmeahq","gwhhbsaxsfbvliaadwhmvqbsmm","yueftullmxjstdjndhavacztpz","qgdfurozusbhkwkweyckjihito","hsyfmokwswpbsqwkfatyvjjxvn","gxtzzykijfwpbcjvujvdjelqad","schvaamxxyfccknyairmbczova","prpczqgmoejptlsdjvxpekdmsl","tpzbifslbahnmqxuwmfpwjaxzd","zmzvxdbuvxqshhkdhcgttgeklo","bapottgrvfphjgetdzjljigrce","qchmszvyupudykrvvmwedikrro","sorbsssghuqanhbaeadihfenfz","xpfxjqibcrdlryqzasbaugrplm","ftqqeqgaecynmwyqrjuexpiyym","qusevqybwtwhfihodctmpxvpsw","jekrjafinseysrjyrjblxbrjkr","kriubpkzljnlghymdmlfcqvkfl","ynelgosfiujenvwsxozpogwmrt","bwovyaupolyunxdizxcvfgiezh","dtnxbsxayqdsrkmyxonxantril","mvuziguweifrcopnhpcrtcuwtz","emmvhnbzhnpogqeolyfdccfdxe","drbwfvjkjkhdmjtkbizodyluie","dnlqhhfxkssbapvllskvekmtcq","pwhxasjncajuqydghjcplakuxl","jlpkgahategcacybcrtftxiziq","tzsqfvyrklitvmvxuyrcqufvvz","llvedwbxmumqwktbyhdojrskid","mflduhadcdsxphellypuupfbjo","eswawcxpdwpoeyvcqxfzubipet","elkipbgwygrkvvkfqcdvlnener","uiubvbcqlxvmcwqwjvbhmwjmpc","bxgzxmsnexgkxmpxabvytmhnsg","rjgwbzxowqrzvpqgkiipaescos","clvozocvmnjrwofvvdswhhghta","oftwnsoxoklkbrekcxcrjdyywc","ypyndfvcvhpetolpotztybclpy","qeqqmxeusoraylprccsnaveqob","ftzqpxlcepcjxdmlgvwhjqarqc","lknkowqqniojgtgayvhvyjozeb","puregmukaplnuklmjgzamqxpqj","banhazwpcyzcoixvanulydhgxg","ualsqdmhjvvefxtskpeybngcps","ynnaealygpljdzzyjyomyrtjvc","cjcrjidyelnhmvuclduprioyls","ubmytsljvuahucisowrccobuds","fyxgsdrbhufncnyjywrvphgimd","aelyvvzpadkvasejnngfgbqdcm","wnqblvpiwsiuwzkkxqnqctbpus","sldozvuccovqppksxvrjtxhvit","blwlvuctjhyflwoaajonydhawf","yanxnkzuuoohugvwvsajsirnyy","ihrbchjartqzistxyufhikkdpi","vobmubnfxwqwsmrepvbakejcwq","tmuylmcheozhyvzbmjaksqzcyo","tgzuvgygvoddrxlgqrjdxititg","pgwijngnatnfbihmebudwtjler","dxrrliurddzesxfjnzpzipwbcx","hqiledlipgjttsuolgvewpenoh","pwmgljestkviesoennjabfeaua","xzkwilxuuskdewkpbhprenwbpk","kyfcxezexydiqrfigudsmalrjt","pplpapcmatogqmnjyiekpwpvra","phjwkhuzokavxhlwzatjlxxjdq","gsyctusmadnyospivhminahewx","lmdzpdgkiyxwqbymtiehjzyyzy","kfwscewqjsfcqerzffwjxmmwrh","urpjthfllddlezfcjknsaquvcm","lnpbcianhthqoxllhuhuzsotej","qcbhulhgowhkeukvxrkhnpznfv","nrzutnhymwbvimvhkmiiadtekc","cymovfxebyfbpctgdoxvxidfxd","tzlxsrjtqtvjjwleksukvgucfz","hazayipsqnzbfaktuvpocennad","bpsnljjapwjvochmnngbrvodxr","hogtixfirpsplzixcrorvigcfy","vpjxvpqtqmxpebotpuumxkjelf","gjafjpyikrvtqkrthzhcgsqrcq","eahepicxhbjbonywaxjrxlusjn","gowwxlxxunfwmzapdqgonvuhcr","bmciwhbxpcbrwgmscrbjtmsffv","wauarejjfnsooljglsygpyaxhi","dqdyxvdkmpzresxyuoeevunsux","rufegbpackdhaoexcgvucgqfnc","fgyqmlgjzhuygifcagnmwowykh","nenxavvhcxbcwwjxtvfuvlqdxl","pkxukiwvhtkdhrmdrnfxsmxszi","vtfcjikclyoqheslgiuhiohswd","qnzlnwlykjeaadsmzekhxdlhso","cswaxylbpvkvvqikxuhuytxtkq","fqjmtbizqhmsmkdlwnykdtusmv","dnndjrkxayykoxogxzqpoascsx","kudirlhijchbxgkmbjcawsnevk","ibredttvihgthxsssivbwkodni","ndfhyjujbdtgafauhclenwwauc","dlhltoeuettryyhahgfvsnqquc","zfovrjecgpvuwafzrcqrnvicwl","wvhtzzjslwrnntlsutdjgflsig","cwzprjhpoteypywhcqxybfaufy","kxpoqgfcxhtcutvicnwrwvbdht","yxuqrnebycfmmbpamcyrlceszk","qtfpzlcdylxjhnoovkprzzdtva","ofsufpklwvxryrdrjhrtpyntdy","jakbpbwgnyrbhmjtfqantjvgma","elcmiulwpdhgtywpkmuwvmugfb","bgkolrjiezcgbtisbadzsbblqy","bysrytewgztiucrvhdrydthsgi","sboobzfttoofahmhggcucroqdg","goijtkucwuxknglrkghfjlvviz","fbsjsfbdbculdfwqscatqffdlj","fovbbaxcponygdrkeikarmrrmu","llufcnbnmptjzqbycflcjyxnjs","wygrygxeliymlswyhfphtxkxza","dnnnwnplkcwkyqamxvuurrmraf","uxuouoqimlaauxwxhqbpkqldsp","gzoxvxqtzjntxpymongdvdmknz","byttjhdbzaiiosssioocvzrqdj","dtbgycbuevtufhhakgjrdbwqvq","iuvzjneslguzdsxjwbvjzxsrmv","sjgstthhqmxltbhokfojcvcavg","qouxkideeitotrmtlkkqbuxspo","gemdupryxphaoxcpobxcvbwwnr","ipwmzvkhoiomobunnifmgorwwm","pvclnzfftblusgyvwgnjfudyrv","hgcqqvwvdxudnhwbarzvnpregc","yegdjsadsklogryoibczqjquck","qqqmlzcpcwcbilnmabkbtqpxsz","ugaonbmhxyqczpcixqarkkfaoc","jduniiuwlqfothrmggvkthljdf","nowqnfexqyhkcdfbquibnskvzv","niqqufjmhieqwuufjntescbpth","xssruebqucbqirkzfsrwsrnard","vykwiekcgcualeubejlglpioyr","zqonaittpznvzaegctezvgrjak","oeeavxiwrfdroahrdzoqfhhokg","wkzeqstrweworaqypfrmznagew","miwoyjugqupmfspaarganpcztq","uqdhjmtdsmqqbakihtcdjxluht","rerhgugynhhapxvzcsosqhmhjb","aqtouyhjvicvlclouebjeaxsyx","bzqsbjniotkfvmpytspzprflmj","nvyflhjvasxfbkzhkraustdtfd","rrpnswfbjacrbuaommysxwhyjk","nbyjogzyrebeorlxmgshudnpjj","wxhsapvmnfteueguylfrgiugbf","qdnplnfptdszrgieohvxirwsko","anbeydgmminizphatxitsigmvf","tdfgzwzqlrmssxtwowqqkfclxc"};

        long a = System.currentTimeMillis();
        List<Integer> ans = test.findSubstring_1(s, words);
        System.out.println("执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");

        System.out.println(ans);

    }
}
