class AuthService {
    getResource = async (url) => {
        let result = await fetch(url);
        if (!result.ok) {
            throw new Error('Could not fetch ${url}, status: ${result.status}');
        }

        return await result.json();
    }

    getAllUsers = () => {
        return this.getResource('');
    }
}