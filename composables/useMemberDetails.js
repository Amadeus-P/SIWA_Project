export default () => {
    const id = useState('id', ()=>null);
    const email = useState('email', ()=>null);
    const profileName = useState('profileName', ()=>null);
    const profileImage = useState('profileImage', ()=>null);
    const roles = useState('roles', ()=>[]);
    const isGhost = ()=> {
        return id === null;
    };

    const signin = (memberInfo) => {
        id.value = memberInfo.id
        email.value = memberInfo.email
        profileName.value = memberInfo.profileName
        profileImage.value = memberInfo.profileImage
        roles.value = memberInfo.roles
    };
    const signout = () => {
        id.value = null;
        email.value = null;
        profileName.value = null;
        profileImage.value = null;
        roles.value = [];
    }
    return {id, email, profileName, profileImage, roles, isGhost, signin, signout };


}