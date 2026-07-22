import java.util.*;
class Solution {
public List<Integer> maxActiveSectionsAfterTrade(String s,int[][] queries){
int n=s.length();int ones=0;
for(int i=0;i<n;i++)if(s.charAt(i)=='1')ones++;
List<int[]> g=new ArrayList<>();int[] idx=new int[n];
for(int i=0;i<n;i++){
if(s.charAt(i)=='0'){
if(i>0&&s.charAt(i-1)=='0')g.get(g.size()-1)[1]++;
else g.add(new int[]{i,1});
}
idx[i]=g.size()-1;
}
int m=g.size();List<Integer> ans=new ArrayList<>();
if(m==0){for(int[] q:queries)ans.add(ones);return ans;}
int mlen=m-1;int[] merge=new int[mlen];
for(int i=0;i<mlen;i++)merge[i]=g.get(i)[1]+g.get(i+1)[1];
int LOG=1;while((1<<LOG)<=mlen)LOG++;
int[][] st=new int[LOG+1][mlen];
if(mlen>0)st[0]=merge.clone();
for(int k=1;k<=LOG;k++)for(int j=0;j+(1<<k)<=mlen;j++)st[k][j]=Math.max(st[k-1][j],st[k-1][j+(1<<(k-1))]);
for(int[] q:queries){
int l=q[0],r=q[1];
int li=idx[l],ri=idx[r];
int left=li==-1?-1:(g.get(li)[1]-(l-g.get(li)[0]));
int right=ri==-1?-1:(r-g.get(ri)[0]+1);
int rBound=s.charAt(r)=='1'?ri:ri-1;
int sa=li+1,ea=rBound-1;
int active=ones;
if(s.charAt(l)=='0'&&s.charAt(r)=='0'&&li+1==ri){
active=Math.max(active,ones+left+right);
}else if(sa<=ea){
int len=ea-sa+1;int k=31-Integer.numberOfLeadingZeros(len);
int mx=Math.max(st[k][sa],st[k][ea-(1<<k)+1]);
active=Math.max(active,ones+mx);
}
if(s.charAt(l)=='0'&&li+1<=rBound)active=Math.max(active,ones+left+g.get(li+1)[1]);
if(s.charAt(r)=='0'&&li<ri-1)active=Math.max(active,ones+right+g.get(ri-1)[1]);
ans.add(active);
}
return ans;
}
}